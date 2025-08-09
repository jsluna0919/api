package co.floristeria.infrastructure.entry_points.dto.pedido;

import co.floristeria.domain.model.pedido.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResumenDTO {
    private Long id;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
}
