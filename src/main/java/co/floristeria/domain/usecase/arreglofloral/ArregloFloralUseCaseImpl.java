package co.floristeria.domain.usecase.arreglofloral;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.arreglofloral.ArregloFloralRepository;
import co.floristeria.domain.usecase.CodeBuilder;
import co.floristeria.domain.usecase.NotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArregloFloralUseCaseImpl implements ArregloFloralUseCase{

    private final ArregloFloralRepository arregloFloralRepository;

    @Override
    public ArregloFloral getArregloFloral(Long id) {
        return arregloFloralRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Arreglo Floral no encontrado"));
    }

    @Override
    public ArregloFloral crearArregloFloral(ArregloFloral arregloFloral) {

        var arregloFloralCreado = CodeBuilder.crearArregloFloral(
                arregloFloral.getNombre(),
                arregloFloral.getDescripcion(),
                arregloFloral.getAnexos(),
                arregloFloral.getImagen(),
                arregloFloral.getMensaje(),
                arregloFloral.getPrecio()
        );
        return arregloFloralRepository.save(arregloFloralCreado);
    }

    @Override
    public List<ArregloFloral> getArreglosFlorales() {
        var arregloFlorals = arregloFloralRepository.findAll()
                .stream()
                .filter(arregloFloral -> arregloFloral.getId() != null)
                .toList();
        if (arregloFlorals.isEmpty()) {
            throw new NotFoundExceptions.NotFoundException("Arreglo Floral no encontrado");
        }else {return arregloFlorals;}
    }

    @Override
    public void deleteArregloFloral(Long id) {
        arregloFloralRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Arreglo Floral no encontrado con ID: " + id));
        arregloFloralRepository.deleteById(id);
    }

    @Override
    public ArregloFloral updateArregloFloral(Long id, ArregloFloral arregloFloral) {

        var arregloFloralExistente = arregloFloralRepository.findById(id);

        if (arregloFloralExistente.isPresent()) {
            var arregloFloralToUpdate = arregloFloralExistente.get();

            // Solo actualiza los campos no nulos
            if (arregloFloral.getNombre() != null)
                arregloFloralToUpdate.setNombre(arregloFloral.getNombre());

            if (arregloFloral.getDescripcion() != null)
                arregloFloralToUpdate.setDescripcion(arregloFloral.getDescripcion());

            if (arregloFloral.getAnexos() != null)
                arregloFloralToUpdate.setAnexos(arregloFloral.getAnexos());

            if (arregloFloral.getImagen() != null)
                arregloFloralToUpdate.setImagen(arregloFloral.getImagen());

            if (arregloFloral.getMensaje() != null)
                arregloFloralToUpdate.setMensaje(arregloFloral.getMensaje());

            if (arregloFloral.getPrecio() != null)
                arregloFloralToUpdate.setPrecio(arregloFloral.getPrecio());

            // Fecha de modificación
            arregloFloralToUpdate.setFechaModificacion(
                    ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDateTime()
            );

            return arregloFloralRepository.save(arregloFloralToUpdate);
        } else {
            throw new NoSuchElementException("Arreglo Floral no encontrado con ID: " + id);
        }
    }
}