package co.floristeria.infrastructure.driven_adapters.jpa.destinatario;

import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.domain.model.destinatario.DestinatarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinatarioJPARepositoryAdapter implements DestinatarioRepository {
    private final DestinatarioJPARepository repository;

    public DestinatarioJPARepositoryAdapter(DestinatarioJPARepository repository) {
        this.repository = repository;
    }
    @Override
    public Optional<Destinatario> findById(Long id) {
        return repository.findById(id).map(DestinatarioMapper::toModel);
    }

    @Override
    public List<Destinatario> findAll() {
        List<DestinatarioEntity> destinatarios = repository.findAll();
        return destinatarios.stream()
                .map(DestinatarioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Destinatario save(Destinatario destinatario) {
        DestinatarioEntity entity = DestinatarioMapper.toEntity(destinatario);
        DestinatarioEntity saved = repository.save(entity);
        return DestinatarioMapper.toModel(saved);
    }

    @Override
    public Destinatario update(Destinatario destinatario) {
        DestinatarioEntity entity = DestinatarioMapper.toEntity(destinatario);
        DestinatarioEntity saved = repository.save(entity);
        return DestinatarioMapper.toModel(saved);
    }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }

    @Override
    public Optional<Destinatario> findByNombreAndTelefono(String nombre, String telefono) {
        return repository.findByNombreAndTelefono(nombre, telefono)
                .map(DestinatarioMapper::toModel);
    }

}

