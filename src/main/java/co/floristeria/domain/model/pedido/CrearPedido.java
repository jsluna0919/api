package co.floristeria.domain.model.pedido;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.destinatario.Destinatario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearPedido {

    private Cliente cliente;
    private ArregloFloral arreglo;
    private Destinatario destinatario;
    private String fechaEntrega;
    private EstadoPedido estado;

}
