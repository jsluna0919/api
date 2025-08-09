package co.floristeria.infrastructure.driven_adapters.jpa.destinatario;

import co.floristeria.infrastructure.driven_adapters.jpa.pedido.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface DestinatarioJPARepository extends JpaRepository<DestinatarioEntity,Long>, QueryByExampleExecutor<DestinatarioEntity> {

    Optional<DestinatarioEntity> findByNombreAndTelefono(String nombre, String telefono);
}
