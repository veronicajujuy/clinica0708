package dh.backend.clinica.service;

import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.entity.Paciente;

import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);

    Optional<Odontologo> buscarPorId(Integer id);
    Odontologo agregarEspecialidad(Integer id_odontologo, Integer id_especialidad);
}
