package co.floristeria.infrastructure.driven_adapters.jpa.arreglofloral;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;

import java.util.Optional;

public final class ArregloFloralMapper {

    public static ArregloFloral toModel(ArregloFloralEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> ArregloFloral.builder()
                        .id(e.getId())
                        .nombre(e.getNombre())
                        .descripcion(e.getDescripcion())
                        .anexos(e.getAnexos())
                        .precio(e.getPrecio())
                        .imagen(e.getImagen())
                        .mensaje(e.getMensaje())
                        .fechaCreacion(e.getFechaCreacion())
                        .fechaModificacion(e.getFechaModificacion())
                        .build())
                .orElse(null);
    }

    public static ArregloFloralEntity toEntity(ArregloFloral model) {
        return Optional.ofNullable(model)
                .map(m -> ArregloFloralEntity.builder()
                        .id(m.getId())
                        .nombre(m.getNombre())
                        .descripcion(m.getDescripcion())
                        .anexos(m.getAnexos())
                        .precio(m.getPrecio())
                        .imagen(m.getImagen())
                        .mensaje(m.getMensaje())
                        .fechaCreacion(m.getFechaCreacion())
                        .fechaModificacion(m.getFechaModificacion())
                        .build())
                .orElse(null);
    }
}