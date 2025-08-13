package co.floristeria.infrastructure.driven_adapters.jpa.destinatario;

import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.infrastructure.driven_adapters.jpa.pedido.PedidoMapper;

import java.util.stream.Collectors;

public class DestinatarioMapper {

    public static Destinatario toModel(DestinatarioEntity entity) {
        if (entity == null) return null;

        Destinatario model = new Destinatario();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setTelefono(entity.getTelefono());
        model.setCiudad(entity.getCiudad());
        model.setDireccion(entity.getDireccion());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaModificacion(entity.getFechaModificacion());
        return model;
    }

    public  static DestinatarioEntity toEntity(Destinatario model) {
        if (model == null) return null;

        DestinatarioEntity entity = new DestinatarioEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setTelefono(model.getTelefono());
        entity.setCiudad(model.getCiudad());
        entity.setDireccion(model.getDireccion());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaModificacion(model.getFechaModificacion());

        if(model.getPedidos() != null){
            entity.setPedidos(model.getPedidos().stream()
                    .map(PedidoMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    public static Destinatario toModelSinPedidos(DestinatarioEntity entity) {
        if (entity == null) return null;

        Destinatario model = new Destinatario();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setTelefono(entity.getTelefono());
        model.setCiudad(entity.getCiudad());
        model.setDireccion(entity.getDireccion());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaModificacion(entity.getFechaModificacion());
        // No se asignan pedidos para este método
        return model;
    }

    public  static DestinatarioEntity toEntitySinPedidos(Destinatario model) {
        if (model == null) return null;

        DestinatarioEntity entity = new DestinatarioEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setTelefono(model.getTelefono());
        entity.setCiudad(model.getCiudad());
        entity.setDireccion(model.getDireccion());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaModificacion(model.getFechaModificacion());

        return entity;
    }
}
