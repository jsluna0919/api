package co.floristeria.infrastructure.driven_adapters.jpa.pedido;

import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.domain.model.pedido.PedidoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PedidoJPARepositoryAdapter implements PedidoRepository {

    private final PedidoJPARepository repository;

    public PedidoJPARepositoryAdapter(PedidoJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return this.repository.findById(id)
                .map(PedidoMapper::toModel);
    }

    @Override
    public List<Pedido> findAll() {
        List<PedidoEntity> entities = (List<PedidoEntity>) repository.findAll();
        return entities.stream()
                .map(PedidoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        PedidoEntity saved = repository.save(entity);
        return  PedidoMapper.toModel(saved);
    }

    @Override
    public Pedido update(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        PedidoEntity saved = repository.save(entity);
        return  PedidoMapper.toModel(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }
}
