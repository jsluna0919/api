package co.floristeria.infrastructure.driven_adapters.jpa.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJPARepository extends JpaRepository<UsuarioEntity,Long> {
}
