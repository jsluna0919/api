package co.floristeria.infrastructure.entry_points.dto.arreglofloral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArregloFloralDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String anexos;
    private String imagen;
    private String mensaje;
    private BigDecimal precio;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
