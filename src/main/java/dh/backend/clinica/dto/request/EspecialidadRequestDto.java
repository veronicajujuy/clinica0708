package dh.backend.clinica.dto.request;

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
public class EspecialidadRequestDto {
    private Integer id;
    @NotBlank
    private String tipo;
}
