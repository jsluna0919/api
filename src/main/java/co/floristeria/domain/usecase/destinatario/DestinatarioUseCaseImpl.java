package co.floristeria.domain.usecase.destinatario;

import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.domain.model.destinatario.DestinatarioRepository;
import co.floristeria.domain.usecase.CodeBuilder;
import co.floristeria.domain.usecase.NotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinatarioUseCaseImpl implements  DestinatarioUseCase {

    private final DestinatarioRepository destinatarioRepository;


    @Override
    public Destinatario getDestinatario(Long id) {
        return destinatarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Destinatario no encontrado con ID: " + id));
    }

    @Override
    public Destinatario crearDestinatario(Destinatario destinatario) {

        var destinatarioCreado = CodeBuilder.crearDestinatario(
                destinatario.getNombre(),
                destinatario.getTelefono(),
                destinatario.getCiudad(),
                destinatario.getDireccion()
        );
        return destinatarioRepository.save(destinatarioCreado);
    }

    @Override
    public List<Destinatario> getDestinatarios() {
        var destinatarios = destinatarioRepository.findAll()
                .stream()
                .filter(destinatario -> destinatario.getId() != null)
                .toList();
        if (destinatarios.isEmpty()) {
            throw new NotFoundExceptions.NotFoundException("No se encontraron destinatarios");
        }else {return destinatarios;}
    }

    @Override
    public void deleteDestinatario(Long id) {
        destinatarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Destinatario no encontrado con ID: " + id));
        destinatarioRepository.deleteById(id);
    }

    @Override
    public Destinatario updateDestinatario(Long id, Destinatario destinatario) {

    var destinatarioExistente = destinatarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Destinatario no encontrado con ID: " + id));

        Optional.ofNullable(destinatario.getNombre()).ifPresent(destinatarioExistente::setNombre);
        Optional.ofNullable(destinatario.getTelefono()).ifPresent(destinatarioExistente::setTelefono);
        Optional.ofNullable(destinatario.getCiudad()).ifPresent(destinatarioExistente::setCiudad);
        Optional.ofNullable(destinatario.getDireccion()).ifPresent(destinatarioExistente::setDireccion);

        destinatarioExistente.setFechaModificacion(
                ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDateTime()
        );

        return destinatarioRepository.save(destinatarioExistente);
    }
}
