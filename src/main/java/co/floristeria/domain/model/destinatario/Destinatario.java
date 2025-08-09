package co.floristeria.domain.model.destinatario;

import co.floristeria.domain.model.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destinatario {

    private Long id;
    private String nombre;
    private String telefono;
    private String ciudad;
    private String direccion;
    private List<Pedido> pedidos = new ArrayList<>();
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
