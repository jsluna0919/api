package co.floristeria.infrastructure.driven_adapters.jpa.pedido;

import co.floristeria.domain.model.pedido.EstadoPedido;
import co.floristeria.infrastructure.driven_adapters.jpa.arreglofloral.ArregloFloralEntity;
import co.floristeria.infrastructure.driven_adapters.jpa.cliente.ClienteEntity;
import co.floristeria.infrastructure.driven_adapters.jpa.destinatario.DestinatarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "arreglo_floral_id", nullable = false)
    private ArregloFloralEntity arreglo;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private DestinatarioEntity destinatario;

    private String fechaEntrega;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @CreatedDate
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
}
