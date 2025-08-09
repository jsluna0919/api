package co.floristeria.infrastructure.entry_points.mapper;


import co.floristeria.domain.model.pedido.CrearPedido;
import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.infrastructure.entry_points.dto.pedido.CrearPedidoDTO;
import co.floristeria.infrastructure.entry_points.dto.pedido.PedidoDTO;
import co.floristeria.infrastructure.entry_points.dto.pedido.PedidoResumenDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .cliente(ClienteMapper.toClienteResumenDTO(pedido.getCliente()))
                .arreglo(ArregloFloralMapper.toArregloFloralResumenDTO(pedido.getArreglo()))
                .destinatario(DestinatarioMapper.toDestinatarioResumenDTO(pedido.getDestinatario()))
                .fechaEntrega(pedido.getFechaEntrega())
                .estado(pedido.getEstado())
                .fechaCreacion(pedido.getFechaCreacion())
                .fechaModificacion(pedido.getFechaModificacion())
                .build();
    }

    public static List<PedidoResumenDTO> toPedidoResumenDTO(List<Pedido> pedidos) {
        if(pedidos.isEmpty()) return List.of();
        return pedidos.stream()
                .map(pedido -> PedidoResumenDTO.builder()
                        .id(pedido.getId())
                        .estado(pedido.getEstado())
                        .fechaCreacion(pedido.getFechaCreacion())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<PedidoDTO> toPedidoDTOList(List<Pedido> pedidos) {
        if(pedidos == null || pedidos.isEmpty()) return List.of();
        return pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
    }

    public static CrearPedido toCrearPedido(CrearPedidoDTO dto) {
        if(dto == null) return  null;
        return new CrearPedido(
                ClienteMapper.fromDTO(dto.getCliente()),
                ArregloFloralMapper.fromDTO(dto.getArreglo()),
                DestinatarioMapper.fromDTO(dto.getDestinatario()),
                dto.getFechaEntrega(),
                dto.getEstado()
        );

    }
}
