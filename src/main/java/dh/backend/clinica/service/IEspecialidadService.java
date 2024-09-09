package dh.backend.clinica.service;

import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.dto.response.EspecialidadResponseDto;
import dh.backend.clinica.entity.Especialidad;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    EspecialidadResponseDto guardarEspecialidad(EspecialidadRequestDto especialidad);
    Optional<EspecialidadResponseDto> buscarEspecialidad(Integer id);
    List<EspecialidadResponseDto> listarEspecialidades();
    void modificarEspecialidad(EspecialidadRequestDto especialidadRequestDto);
    void eliminarEspecialidad(Integer id);

}
