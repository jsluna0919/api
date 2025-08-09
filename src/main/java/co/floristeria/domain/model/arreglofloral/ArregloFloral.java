package co.floristeria.domain.model.arreglofloral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArregloFloral {
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
