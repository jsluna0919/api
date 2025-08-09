package co.floristeria.infrastructure.entry_points.mapper;

import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.infrastructure.entry_points.dto.cliente.ClienteDTO;
import co.floristeria.infrastructure.entry_points.dto.cliente.ClienteResumenDTO;

public class ClienteMapper {

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .pedidos(PedidoMapper.toPedidoResumenDTO(cliente.getPedidos()))
                .fechaCreacion(cliente.getFechaCreacion())
                .fechaModificacion(cliente.getFechaModificacion())
                .build();
    }

    public static ClienteResumenDTO toClienteResumenDTO(Cliente cliente) {
        return ClienteResumenDTO.builder()
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .build();
    }

    public static Cliente fromDTO(ClienteResumenDTO dto) {
        if (dto == null) return null;
        return Cliente.builder()
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .ciudad(dto.getCiudad())
                .direccion(dto.getDireccion())
                .build();
    }

}
