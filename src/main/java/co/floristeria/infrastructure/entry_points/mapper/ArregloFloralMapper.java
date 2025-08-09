package co.floristeria.infrastructure.entry_points.mapper;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.infrastructure.entry_points.dto.arreglofloral.ArregloFloralDTO;
import co.floristeria.infrastructure.entry_points.dto.arreglofloral.ArregloFloralResumenDTO;

public class ArregloFloralMapper {

    public static ArregloFloralDTO toArregloFloralDTO(ArregloFloral arreglo) {
        return ArregloFloralDTO.builder()
                .id(arreglo.getId())
                .nombre(arreglo.getNombre())
                .descripcion(arreglo.getDescripcion())
                .anexos(arreglo.getAnexos())
                .imagen(arreglo.getImagen())
                .mensaje(arreglo.getMensaje())
                .precio(arreglo.getPrecio())
                .fechaCreacion(arreglo.getFechaCreacion())
                .fechaModificacion(arreglo.getFechaModificacion())
                .build();
    }

    public static ArregloFloralResumenDTO toArregloFloralResumenDTO(ArregloFloral arreglo) {
        return ArregloFloralResumenDTO.builder()
                .nombre(arreglo.getNombre())
                .descripcion(arreglo.getDescripcion())
                .anexos(arreglo.getAnexos())
                .imagen(arreglo.getImagen())
                .mensaje(arreglo.getMensaje())
                .precio(arreglo.getPrecio())
                .build();
    }

    public static ArregloFloral fromDTO(ArregloFloralResumenDTO dto) {
        if (dto == null) return null;
        return ArregloFloral.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .anexos(dto.getAnexos())
                .imagen(dto.getImagen())
                .mensaje(dto.getMensaje())
                .precio(dto.getPrecio())
                .build();
    }
}
