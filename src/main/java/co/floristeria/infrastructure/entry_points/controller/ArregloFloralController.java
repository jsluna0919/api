package co.floristeria.infrastructure.entry_points.controller;

import co.floristeria.domain.usecase.arreglofloral.ArregloFloralUseCase;
import co.floristeria.infrastructure.entry_points.dto.arreglofloral.ArregloFloralResumenDTO;
import co.floristeria.infrastructure.entry_points.mapper.ArregloFloralMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/arreglos-florales")
class ArregloFloralController {

    private final ArregloFloralUseCase arregloFloralUseCase;
    public ArregloFloralController(ArregloFloralUseCase arregloFloralUseCase) {
        this.arregloFloralUseCase = arregloFloralUseCase;
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<?> listarArreglosFlorales() {
        try {
            var arreglosFlorales = arregloFloralUseCase.getArreglosFlorales();
            var arregloFloralDTOs = ArregloFloralMapper.arregloFloralDTOList(arreglosFlorales);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Lista de arreglos florales obtenida exitosamente", arregloFloralDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al obtener la lista de arreglos florales", null));
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getArregloFloral(@PathVariable Long id) {
        try {
            var arregloFloral = arregloFloralUseCase.getArregloFloral(id);
            var arregloFloralDTO = ArregloFloralMapper.toArregloFloralDTO(arregloFloral);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Arreglo floral encontrado", arregloFloralDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Arreglo floral no encontrado con ID: " + id, null));
        }
    }

    @PutMapping(path = "/modificar/{id}")
    public ResponseEntity<?> actualizarArregloFloral(@PathVariable Long id, @RequestBody ArregloFloralResumenDTO dto) {
        try {
            var arregloFloral = ArregloFloralMapper.fromDTO(dto);
            arregloFloral.setId(id);
            var arregloFloralActualizado = arregloFloralUseCase.updateArregloFloral(id, arregloFloral);
            var arregloFloralDTO = ArregloFloralMapper.toArregloFloralDTO(arregloFloralActualizado);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Arreglo floral actualizado", arregloFloralDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al actualizar el arreglo floral", null));
        }
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarArregloFloral(@PathVariable Long id) {
        try {
            arregloFloralUseCase.deleteArregloFloral(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Arreglo floral eliminado exitosamente", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al eliminar el arreglo floral", null));
        }
    }
}
