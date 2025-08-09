package co.floristeria.infrastructure.entry_points.mapper;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.domain.model.pedido.CrearPedido;
import co.floristeria.infrastructure.entry_points.dto.pedido.CrearPedidoDTO;

public class CrearPedidoMapper {

    public static CrearPedido toCrearPedido(CrearPedidoDTO dto){
        if(dto == null) return  null;

        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(dto.getCliente().getTipoDocumento());
        cliente.setNumeroDocumento(dto.getCliente().getNumeroDocumento());
        cliente.setNombre(dto.getCliente().getNombre());
        cliente.setApellido(dto.getCliente().getApellido());
        cliente.setTelefono(dto.getCliente().getTelefono());
        cliente.setEmail(dto.getCliente().getEmail());
        cliente.setCiudad(dto.getCliente().getCiudad());
        cliente.setDireccion(dto.getCliente().getDireccion());

        Destinatario destinatario = new Destinatario();
        destinatario.setNombre(dto.getDestinatario().getNombre());
        destinatario.setTelefono(dto.getDestinatario().getTelefono());
        destinatario.setCiudad(dto.getDestinatario().getCiudad());
        destinatario.setDireccion(dto.getDestinatario().getDireccion());

        ArregloFloral arreglo = new ArregloFloral();
        arreglo.setNombre(dto.getArreglo().getNombre());
        arreglo.setDescripcion(dto.getArreglo().getDescripcion());
        arreglo.setAnexos(dto.getArreglo().getAnexos());
        arreglo.setPrecio(dto.getArreglo().getPrecio());
        arreglo.setImagen(dto.getArreglo().getImagen());
        arreglo.setMensaje(dto.getArreglo().getMensaje());

        return new CrearPedido(
                cliente,
                arreglo,
                destinatario,
                dto.getFechaEntrega(),
                dto.getEstado()
        );
    }
}
