package dh.backend.clinica.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dh.backend.clinica.utils.GsonProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nroMatricula;
    private String apellido;
    private String nombre;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "odontologo-turno")
    //@JsonIgnore
    private Set<Turno> turnoSet;

    @ManyToMany
    @JoinTable(name="odontologos_especialidades",
    joinColumns = @JoinColumn(name="odontologos_id"),
    inverseJoinColumns = @JoinColumn(name="especialidad_id"))
    @JsonIgnoreProperties("odontologos")
    Set<Especialidad> especialidades = new HashSet<>();

    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
