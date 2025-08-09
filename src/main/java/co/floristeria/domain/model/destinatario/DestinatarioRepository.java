package co.floristeria.domain.model.destinatario;

import java.util.List;
import java.util.Optional;

public interface DestinatarioRepository {

    Optional<Destinatario> findById(Long id);
    List<Destinatario> findAll();
    Destinatario save(Destinatario destinatario);
    Destinatario update(Destinatario destinatario);
    void deleteById(Long id);
    Optional<Destinatario> findByNombreAndTelefono(String nombre, String telefono);

}
