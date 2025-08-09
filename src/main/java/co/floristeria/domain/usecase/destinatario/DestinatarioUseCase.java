package co.floristeria.domain.usecase.destinatario;

import co.floristeria.domain.model.destinatario.Destinatario;

import java.util.List;

public interface DestinatarioUseCase {

    Destinatario getDestinatario(Long id);

    Destinatario crearDestinatario(Destinatario destinatario);

    List<Destinatario> getDestinatarios();

    void deleteDestinatario(Long id);

    Destinatario updateDestinatario(Long id, Destinatario destinatario);
}
