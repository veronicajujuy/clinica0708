package dh.backend.clinica.service.impl;

import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.exception.ResourceNotFoundException;
import dh.backend.clinica.repository.IEspecialidadRepository;
import dh.backend.clinica.repository.IOdontologoRepository;
import dh.backend.clinica.service.IEspecialidadService;
import dh.backend.clinica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    private IEspecialidadRepository especialidadRepository;

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarPorId(Integer id) {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        if(odontologoEncontrado.isPresent()){
            return odontologoEncontrado;
        } else {
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }

    @Override
    public Odontologo agregarEspecialidad(Integer id_odontologo, Integer id_especialidad) {
        Optional<Odontologo> odontologoOptional = buscarPorId(id_odontologo);
        Optional<Especialidad> especialidadEncontrada = especialidadRepository.findById(id_especialidad);
        Odontologo odontologo = null;
        if(odontologoOptional.isPresent() && especialidadEncontrada.isPresent()){
            odontologo = odontologoOptional.get();
            odontologo.getEspecialidades().add(especialidadEncontrada.get());
            odontologoRepository.save(odontologo);
        } else throw new ResourceNotFoundException("Odontologo o especialidad no encontrados");
        return odontologo;
    }
}
