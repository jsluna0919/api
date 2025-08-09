package co.floristeria.domain.usecase;

import co.floristeria.domain.model.arreglofloral.ArregloFloral;
import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.model.destinatario.Destinatario;
import co.floristeria.domain.model.pedido.EstadoPedido;
import co.floristeria.domain.model.pedido.Pedido;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@UtilityClass
public class CodeBuilder {

    private static LocalDateTime fechaCreacion() {
        return ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDateTime();
    }


    public static Pedido crearPedido(Cliente cliente,
                                     ArregloFloral arregloFloral,
                                     Destinatario destinatario,
                                     String fechaEntrega,
                                     EstadoPedido estado) {
        return Pedido.builder()
                .cliente(cliente)
                .arreglo(arregloFloral)
                .destinatario(destinatario)
                .fechaEntrega(fechaEntrega)
                .estado(estado) // Estado por defecto
                .fechaCreacion(fechaCreacion())
                .build();
    }

    public static Cliente crearCliente(String tipoDocumento,
                                       String numeroDocumento,
                                       String nombre,
                                       String apellido,
                                       String telefono,
                                       String email,
                                       String ciudad,
                                       String direccion) {
        return Cliente.builder()
                .tipoDocumento(tipoDocumento)
                .numeroDocumento(numeroDocumento)
                .nombre(nombre)
                .apellido(apellido)
                .telefono(telefono)
                .email(email)
                .ciudad(ciudad)
                .direccion(direccion)
                .fechaCreacion(fechaCreacion())
                .build();
    }

    public static Destinatario crearDestinatario(String nombre,
                                                 String telefono,
                                                 String ciudad,
                                                 String direccion) {

        return Destinatario.builder()
                .nombre(nombre)
                .telefono(telefono)
                .ciudad(ciudad)
                .direccion(direccion)
                .fechaCreacion(fechaCreacion())
                .build();
    }

    public static ArregloFloral crearArregloFloral(String nombre,
                                                   String descripcion,
                                                   String anexos,
                                                   String imagen,
                                                   String mensaje,
                                                   BigDecimal precio) {
        return ArregloFloral.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .anexos(anexos)
                .precio(precio)
                .imagen(imagen)
                .mensaje(mensaje)
                .fechaCreacion(fechaCreacion())
                .build();
    }
}