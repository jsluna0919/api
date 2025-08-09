package co.floristeria.domain.model.pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    Optional<Pedido> findById(Long id);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    Pedido update(Pedido pedido);
    void deleteById(Long id);
}
