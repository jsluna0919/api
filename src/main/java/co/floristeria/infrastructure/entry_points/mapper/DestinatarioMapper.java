package co.floristeria.infrastructure.entry_points.mapper;

import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.infrastructure.entry_points.dto.destinatario.DestinatarioDTO;
import co.floristeria.infrastructure.entry_points.dto.destinatario.DestinatarioResumenDTO;

public class DestinatarioMapper {

    public static DestinatarioDTO toDestinatarioDTO(Destinatario destinatario) {
        return DestinatarioDTO.builder()
                .id(destinatario.getId())
                .nombre(destinatario.getNombre())
                .telefono(destinatario.getTelefono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .pedidos(PedidoMapper.toPedidoResumenDTO(destinatario.getPedidos()))
                .fechaCreacion(destinatario.getFechaCreacion())
                .fechaModificacion(destinatario.getFechaModificacion())
                .build();
    }

    public static DestinatarioResumenDTO toDestinatarioResumenDTO(Destinatario destinatario) {
        return DestinatarioResumenDTO.builder()
                .nombre(destinatario.getNombre())
                .telefono(destinatario.getTelefono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .build();
    }

    public static Destinatario fromDTO(DestinatarioResumenDTO dto) {
        if (dto == null) return null;
        return Destinatario.builder()
                .nombre(dto.getNombre())
                .telefono(dto.getTelefono())
                .ciudad(dto.getCiudad())
                .direccion(dto.getDireccion())
                .build();
    }
}
