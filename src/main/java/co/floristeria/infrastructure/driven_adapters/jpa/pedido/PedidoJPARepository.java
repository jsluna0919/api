package co.floristeria.infrastructure.driven_adapters.jpa.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PedidoJPARepository extends JpaRepository<PedidoEntity, Long>,
        QueryByExampleExecutor<PedidoEntity> {

    // Additional query methods can be defined here if needed{
}
