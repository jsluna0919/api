package co.floristeria.infrastructure.entry_points.dto.destinatario;

import co.floristeria.infrastructure.entry_points.dto.pedido.PedidoResumenDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinatarioDTO {

    private Long id;
    private String nombre;
    private String telefono;
    private String ciudad;
    private String direccion;
    private List<PedidoResumenDTO> pedidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
