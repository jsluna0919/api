package co.floristeria.domain.usecase.arreglofloral;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;

import java.util.List;

public interface ArregloFloralUseCase {

    ArregloFloral getArregloFloral(Long id);
    ArregloFloral crearArregloFloral(ArregloFloral arregloFloral);
    List<ArregloFloral> getArreglosFlorales();
    void deleteArregloFloral(Long id);
    ArregloFloral updateArregloFloral(Long id, ArregloFloral arregloFloral);
}
