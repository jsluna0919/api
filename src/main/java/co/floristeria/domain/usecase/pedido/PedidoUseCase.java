package co.floristeria.domain.usecase.pedido;

import co.floristeria.domain.model.pedido.CrearPedido;
import co.floristeria.domain.model.pedido.Pedido;

import java.util.List;

public interface PedidoUseCase {
    Pedido crearPedido(CrearPedido crearPedido);
    Pedido getPedido(Long id);
    List<Pedido> getAllPedidos();
    void deletePedido(Long id);
    Pedido updatePedido(Long id,Pedido pedido);
}
