package co.floristeria.infrastructure.entry_points.dto.destinatario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinatarioResumenDTO {

    private String nombre;
    private String telefono;
    private String ciudad;
    private String direccion;
}
