package co.floristeria.domain.usecase.pedido;


import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.arreglofloral.ArregloFloralRepository;
import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.cliente.ClienteRepository;
import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.domain.model.destinatario.DestinatarioRepository;
import co.floristeria.domain.model.pedido.CrearPedido;
import co.floristeria.domain.model.pedido.EstadoPedido;
import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.domain.model.pedido.PedidoRepository;
import co.floristeria.domain.usecase.CodeBuilder;
import co.floristeria.domain.usecase.NotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoUseCaseImpl implements  PedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final DestinatarioRepository destinatarioRepository;
    private final ClienteRepository clienteRepository;
    private final ArregloFloralRepository arregloFloralRepository;

    @Override
    public Pedido crearPedido(CrearPedido crearPedido) {

        Cliente cliente = clienteRepository
                .findByDocumento(
                    crearPedido.getCliente().getTipoDocumento(),
                    crearPedido.getCliente().getNumeroDocumento())
                .orElseGet(()-> clienteRepository.save(
                    CodeBuilder.crearCliente(
                        crearPedido.getCliente().getTipoDocumento(),
                        crearPedido.getCliente().getNumeroDocumento(),
                        crearPedido.getCliente().getNombre(),
                        crearPedido.getCliente().getApellido(),
                        crearPedido.getCliente().getTelefono(),
                        crearPedido.getCliente().getEmail(),
                        crearPedido.getCliente().getCiudad(),
                        crearPedido.getCliente().getDireccion()
                    )
                ));

        Destinatario destinatario = destinatarioRepository
                .findByNombreAndTelefono(
                    crearPedido.getDestinatario().getNombre(),
                        crearPedido.getDestinatario().getTelefono())
                .orElseGet(() -> destinatarioRepository.save(
                        CodeBuilder.crearDestinatario(
                        crearPedido.getDestinatario().getNombre(),
                        crearPedido.getDestinatario().getTelefono(),
                        crearPedido.getDestinatario().getCiudad(),
                        crearPedido.getDestinatario().getDireccion()
                    )
                ));

        ArregloFloral arregloFloral = arregloFloralRepository.save(
                CodeBuilder.crearArregloFloral(
                        crearPedido.getArreglo().getNombre(),
                        crearPedido.getArreglo().getDescripcion(),
                        crearPedido.getArreglo().getAnexos(),
                        crearPedido.getArreglo().getImagen(),
                        crearPedido.getArreglo().getMensaje(),
                        crearPedido.getArreglo().getPrecio()
                )
        );

        var pedido = CodeBuilder.crearPedido(
                cliente,
                arregloFloral,
                destinatario,
                crearPedido.getFechaEntrega(),
                EstadoPedido.PENDIENTE);

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Pedido no encontrado con ID: " + id));
    }

    @Override
    public List<Pedido> getAllPedidos() {
        var pedidos = pedidoRepository.findAll();
        if (pedidos.isEmpty()) {
            throw new NotFoundExceptions.NotFoundException("No se encontraron pedidos");
        }
        return pedidos;
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Pedido no encontrado con ID: " + id));
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido updatePedido(Long id,Pedido pedido) {
        var pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions.NotFoundException("Pedido no encontrado con ID: " + id));

        Optional.ofNullable(pedido.getFechaEntrega()).ifPresent(pedidoExistente::setFechaEntrega);
        pedidoExistente.setFechaModificacion(
                ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDateTime()
        );
        return pedidoRepository.save(pedidoExistente);
    }
}
