package co.floristeria.domain.usecase.cliente;

import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.cliente.ClienteRepository;
import co.floristeria.domain.usecase.CodeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImp implements ClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {

        var clienteCreado = CodeBuilder.crearCliente(
                cliente.getTipoDocumento(),
                cliente.getNumeroDocumento(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCiudad(),
                cliente.getDireccion()
        );
        return clienteRepository.save(clienteCreado);
    }

    @Override
    public List<Cliente> getClientes() {
        var clientes = clienteRepository.findAll()
                .stream()
                .filter(cliente -> cliente.getId() != null)
                .toList();
        if (clientes.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron clientes");
        }
        return clientes;
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {

        var clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            var clienteToUpdate = clienteExistente.get();

            if (cliente.getTipoDocumento() != null) {
                clienteToUpdate.setTipoDocumento(cliente.getTipoDocumento());
            }
            if (cliente.getNumeroDocumento() != null) {
                clienteToUpdate.setNumeroDocumento(cliente.getNumeroDocumento());}

            if (cliente.getNombre() != null) {
                clienteToUpdate.setNombre(cliente.getNombre());
            }

            if (cliente.getApellido() != null) {
                clienteToUpdate.setApellido(cliente.getApellido());
            }

            if (cliente.getTelefono() != null) {
                clienteToUpdate.setTelefono(cliente.getTelefono());
            }

            if (cliente.getEmail() != null) {
                clienteToUpdate.setEmail(cliente.getEmail());
            }

            if (cliente.getCiudad() != null) {
                clienteToUpdate.setCiudad(cliente.getCiudad());
            }

            if (cliente.getDireccion() != null) {
                clienteToUpdate.setDireccion(cliente.getDireccion());
            }

            clienteToUpdate.setFechaModificacion(ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDateTime());

            return clienteRepository.save(clienteToUpdate);
        }else{
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + id);
        }
    }
}
