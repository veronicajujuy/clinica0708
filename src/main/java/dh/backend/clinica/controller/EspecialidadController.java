package dh.backend.clinica.controller;


import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.service.IEspecialidadService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    private IEspecialidadService especialidadService;

    public EspecialidadController(IEspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarEspecialidad(@RequestBody EspecialidadRequestDto especialidadRequestDto){
        return ResponseEntity.ok(especialidadService.guardarEspecialidad(especialidadRequestDto)) ;
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<?> buscartodos(){
        return ResponseEntity.ok(especialidadService.listarEspecialidades());
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(especialidadService.buscarEspecialidad(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        return ResponseEntity.ok(especialidadService.equals(id));
    }

}
