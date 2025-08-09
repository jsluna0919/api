package co.floristeria.infrastructure.entry_points.dto.arreglofloral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArregloFloralResumenDTO {

    private String nombre;
    private String descripcion;
    private String anexos;
    private String imagen;
    private String mensaje;
    private BigDecimal precio;
}
