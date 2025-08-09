package co.floristeria.domain.model.cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
    Optional<Cliente> findByDocumento(String tipoDocumento, String numeroDocumento);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteById(Long id);

}
