package co.floristeria.infrastructure.driven_adapters.jpa.arreglofloral;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.arreglofloral.ArregloFloralRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ArregloFloralJPARepositoryAdapter implements ArregloFloralRepository {
    private final ArregloFloralJPARepository repository;

    public ArregloFloralJPARepositoryAdapter(ArregloFloralJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ArregloFloral> findById(Long id) {
        return this.repository.findById(id)
                .map(ArregloFloralMapper::toModel);
    }

    @Override
    public List<ArregloFloral> findAll() {
        List<ArregloFloralEntity> arregloFlorales = (List<ArregloFloralEntity>) repository.findAll();
        return arregloFlorales.stream()
                .map(ArregloFloralMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ArregloFloral save(ArregloFloral arregloFloral) {
        ArregloFloralEntity entity = ArregloFloralMapper.toEntity(arregloFloral);
        ArregloFloralEntity saved = repository.save(entity);
        return ArregloFloralMapper.toModel(saved);
    }

    @Override
    public ArregloFloral update(ArregloFloral arregloFloral) {
        ArregloFloralEntity entity = ArregloFloralMapper.toEntity(arregloFloral);
        ArregloFloralEntity saved = repository.save(entity);
        return ArregloFloralMapper.toModel(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
