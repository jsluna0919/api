package co.floristeria.infrastructure.driven_adapters.jpa.arreglofloral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ArregloFloralJPARepository extends JpaRepository<ArregloFloralEntity, Long>,
        QueryByExampleExecutor<ArregloFloralEntity> {}
