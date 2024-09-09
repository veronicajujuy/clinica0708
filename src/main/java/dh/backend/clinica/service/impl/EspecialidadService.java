package dh.backend.clinica.service.impl;

import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.dto.response.EspecialidadResponseDto;
import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.exception.ResourceNotFoundException;
import dh.backend.clinica.repository.IEspecialidadRepository;
import dh.backend.clinica.service.IEspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService implements IEspecialidadService {
    @Autowired
    private ModelMapper modelMapper;
    private IEspecialidadRepository especialidadRepository;

    public EspecialidadService(IEspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadResponseDto guardarEspecialidad(EspecialidadRequestDto especialidadRequestDto) {
        Especialidad especialidad = convertirAEspecialidad(especialidadRequestDto);
        Especialidad especialidadGuardada = especialidadRepository.save(especialidad);
        return convertirAResponse(especialidadGuardada);
    }

    @Override
    public Optional<EspecialidadResponseDto> buscarEspecialidad(Integer id) {
        Optional<Especialidad> especialidadEncontrada =especialidadRepository.findById(id);
        if(especialidadEncontrada.isPresent()){
            return Optional.ofNullable(convertirAResponse(especialidadEncontrada.get()));
        } else {
            throw new ResourceNotFoundException("La especialidad no fue encontrada");
        }
    }

    @Override
    public List<EspecialidadResponseDto> listarEspecialidades() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        List<EspecialidadResponseDto> especialidadAResponder = new ArrayList<>();
        for(Especialidad e: especialidades){
            especialidadAResponder.add(convertirAResponse(e));
        }
        return especialidadAResponder;
    }

    @Override
    public void modificarEspecialidad(EspecialidadRequestDto especialidadRequestDto) {
        Especialidad especialidad = convertirAEspecialidad(especialidadRequestDto);
        Optional<Especialidad> especialidadEncontrada =especialidadRepository.findById(especialidad.getId());
        if(especialidadEncontrada.isPresent()){
            especialidadRepository.save(especialidad);
        } else {
            throw new ResourceNotFoundException("La especialidad no fue encontrada");
        }
    }

    @Override
    public void eliminarEspecialidad(Integer id) {
        Optional<Especialidad> especialidadEncontrada =especialidadRepository.findById(id);
        if(especialidadEncontrada.isPresent()){
            especialidadRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("La especialidad no fue encontrada");
        }
    }

    private EspecialidadResponseDto convertirAResponse(Especialidad especialidad){
        return modelMapper.map(especialidad, EspecialidadResponseDto.class);
    }

    private Especialidad convertirAEspecialidad(EspecialidadRequestDto especialidad){
        return modelMapper.map(especialidad, Especialidad.class);
    }
}
