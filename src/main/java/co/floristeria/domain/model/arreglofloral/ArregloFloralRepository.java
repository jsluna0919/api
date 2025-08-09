package co.floristeria.domain.model.arreglofloral;

import java.util.List;
import java.util.Optional;

public interface ArregloFloralRepository {

    Optional<ArregloFloral> findById(Long id);
    List<ArregloFloral> findAll();
    ArregloFloral save(ArregloFloral arregloFloral);
    ArregloFloral update(ArregloFloral arregloFloral);
    void deleteById(Long id);
}