package co.floristeria.infrastructure.driven_adapters.jpa.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface ClienteJPARepository extends JpaRepository<ClienteEntity, Long>,
        QueryByExampleExecutor<ClienteEntity> {

    Optional<ClienteEntity> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);


}
