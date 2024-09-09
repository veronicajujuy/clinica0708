package dh.backend.clinica.dto.response;

import dh.backend.clinica.entity.Odontologo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadResponseDto {
    private Integer id;
    private String tipo;
    private Set<OdontologoResponseDto> odontologos;
}
