package co.floristeria.domain.usecase.cliente;

import co.floristeria.domain.model.cliente.Cliente;

import java.util.List;

public interface ClienteUseCase {

    Cliente getCliente(Long id);

    Cliente crearCliente(Cliente cliente);

    List<Cliente> getClientes();

    void deleteCliente(Long id);

    Cliente updateCliente(Long id, Cliente cliente);
}
