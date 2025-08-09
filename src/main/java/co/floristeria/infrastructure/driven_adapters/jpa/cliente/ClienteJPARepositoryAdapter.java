package co.floristeria.infrastructure.driven_adapters.jpa.cliente;

import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.cliente.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteJPARepositoryAdapter implements ClienteRepository {

    private final ClienteJPARepository repository;

    public ClienteJPARepositoryAdapter(ClienteJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return this.repository.findById(id)
                .map(ClienteMapper::toModel);
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteEntity> clientes = (List<ClienteEntity>) repository.findAll();
        return clientes.stream()
                .map(ClienteMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> findByDocumento(String tipoDocumento, String numeroDocumento) {
        return repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento)
                .map(ClienteMapper::toModel);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = ClienteMapper.toEntity(cliente);
        ClienteEntity saved = repository.save(entity);
        return ClienteMapper.toModel(saved);
    }

    @Override
    public Cliente update(Cliente cliente) {
        ClienteEntity entity = ClienteMapper.toEntity(cliente);
        ClienteEntity saved = repository.save(entity);
        return ClienteMapper.toModel(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}