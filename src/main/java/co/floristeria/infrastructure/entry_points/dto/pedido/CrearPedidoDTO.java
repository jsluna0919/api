package co.floristeria.infrastructure.entry_points.dto.pedido;

import co.floristeria.domain.model.pedido.EstadoPedido;
import co.floristeria.infrastructure.entry_points.dto.arreglofloral.ArregloFloralResumenDTO;
import co.floristeria.infrastructure.entry_points.dto.cliente.ClienteResumenDTO;
import co.floristeria.infrastructure.entry_points.dto.destinatario.DestinatarioResumenDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CrearPedidoDTO {

    private ClienteResumenDTO cliente;
    private ArregloFloralResumenDTO arreglo;
    private DestinatarioResumenDTO destinatario;
    private String fechaEntrega;
    private EstadoPedido estado;
}
