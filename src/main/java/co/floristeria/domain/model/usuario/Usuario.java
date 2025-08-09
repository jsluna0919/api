package co.floristeria.domain.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contrasena; // Esta debe guardarse cifrada con BCrypt
    private RolUsuario rol; // Ejemplo: ADMIN, CLIENTE, REPARTIDOR
    private boolean estado; // Ejemplo: ACTIVO, INACTIVO
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaUltimoAcceso; // Fecha del último acceso del usuario
}
