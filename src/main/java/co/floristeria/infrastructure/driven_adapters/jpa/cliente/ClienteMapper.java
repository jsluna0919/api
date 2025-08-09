package co.floristeria.infrastructure.driven_adapters.jpa.cliente;

import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.infrastructure.driven_adapters.jpa.pedido.PedidoEntity;

import java.util.stream.Collectors;

public class ClienteMapper {

    public static Cliente toModel(ClienteEntity entity){
        if(entity == null) return null;

        Cliente model = new Cliente();
        model.setId(entity.getId());
        model.setTipoDocumento(entity.getTipoDocumento());
        model.setNumeroDocumento(entity.getNumeroDocumento());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setTelefono(entity.getTelefono());
        model.setEmail(entity.getEmail());
        model.setCiudad(entity.getCiudad());
        model.setDireccion(entity.getDireccion());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaModificacion(entity.getFechaModificacion());/*
        if(entity.getPedidos() != null) {
            model.setPedidos(entity.getPedidos().stream()
                    .map(pedidoEntity -> {
                        Pedido pedido = new Pedido();
                        pedido.setId(pedidoEntity.getId());
                        pedido.setFechaCreacion(pedidoEntity.getFechaCreacion());
                        return pedido;
                    }).collect(Collectors.toList())
            );
        }*/
        return  model;
    }

    public static ClienteEntity toEntity(Cliente model){
        if(model == null) return null;

        ClienteEntity entity = new ClienteEntity();
        entity.setId(model.getId());
        entity.setTipoDocumento(model.getTipoDocumento());
        entity.setNumeroDocumento(model.getNumeroDocumento());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setTelefono(model.getTelefono());
        entity.setEmail(model.getEmail());
        entity.setCiudad(model.getCiudad());
        entity.setDireccion(model.getDireccion());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaModificacion(model.getFechaModificacion());
        if (model.getPedidos() != null) {
            entity.setPedidos(model.getPedidos().stream()
                    .map(pedidoModel -> {
                        PedidoEntity pedidoEntity = new PedidoEntity();
                        pedidoEntity.setId(pedidoModel.getId());
                        pedidoEntity.setFechaCreacion(pedidoModel.getFechaCreacion());
                        return pedidoEntity;
                    })
                    .collect(Collectors.toList())
            );
        }
        return  entity;
    }
}
