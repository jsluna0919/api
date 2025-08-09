package co.floristeria.infrastructure.driven_adapters.jpa.pedido;

import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.infrastructure.driven_adapters.jpa.arreglofloral.ArregloFloralMapper;
import co.floristeria.infrastructure.driven_adapters.jpa.cliente.ClienteMapper;
import co.floristeria.infrastructure.driven_adapters.jpa.destinatario.DestinatarioMapper;

public class PedidoMapper {

    public static Pedido toModel(PedidoEntity entity) {
        if (entity == null) return null;

        Pedido model = new Pedido();
        model.setId(entity.getId());
        model.setCliente(ClienteMapper.toModel/*toModelSinPedido*/(entity.getCliente()));
        model.setArreglo(ArregloFloralMapper.toModel(entity.getArreglo()));
        model.setDestinatario(DestinatarioMapper.toModelSinPedidos(entity.getDestinatario()));
        model.setFechaEntrega(entity.getFechaEntrega());
        model.setEstado(entity.getEstado());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaModificacion(entity.getFechaModificacion());
        return model;
    }

    public static PedidoEntity toEntity(Pedido model) {
        if (model == null) return null;

        PedidoEntity entity = new PedidoEntity();
        entity.setId(model.getId());
        entity.setCliente(ClienteMapper.toEntity/*toEntitySinPedido*/(model.getCliente()));
        entity.setArreglo(ArregloFloralMapper.toEntity(model.getArreglo()));
        entity.setDestinatario(DestinatarioMapper.toEntitySinPedidos(model.getDestinatario()));
        entity.setFechaEntrega(model.getFechaEntrega());
        entity.setEstado(model.getEstado());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaModificacion(model.getFechaModificacion());
        return entity;
    }

    public static Pedido toModelSinClienteYDestinatario(PedidoEntity entity) {
        if (entity == null) return null;

        Pedido model = new Pedido();
        model.setId(entity.getId());
        model.setArreglo(ArregloFloralMapper.toModel(entity.getArreglo()));
        model.setFechaEntrega(entity.getFechaEntrega());
        model.setEstado(entity.getEstado());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaModificacion(entity.getFechaModificacion());
        return model;
    }

    public static PedidoEntity toEntitySinClienteYDestinatario(Pedido model) {
        if (model == null) return null;

        PedidoEntity entity = new PedidoEntity();
        entity.setId(model.getId());
        entity.setArreglo(ArregloFloralMapper.toEntity(model.getArreglo()));
        entity.setFechaEntrega(model.getFechaEntrega());
        entity.setEstado(model.getEstado());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaModificacion(model.getFechaModificacion());
        return entity;
    }
}
