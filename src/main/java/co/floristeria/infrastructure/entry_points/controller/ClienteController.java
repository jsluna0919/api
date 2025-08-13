package co.floristeria.infrastructure.entry_points.controller;

import co.floristeria.domain.model.cliente.Cliente;
import co.floristeria.domain.usecase.cliente.ClienteUseCase;
import co.floristeria.infrastructure.entry_points.dto.cliente.ClienteDTO;
import co.floristeria.infrastructure.entry_points.dto.cliente.ClienteResumenDTO;
import co.floristeria.infrastructure.entry_points.mapper.ClienteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
class ClienteController {

    private final ClienteUseCase clienteUseCase;
    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<?> listarClientes() {

        try{
            List<Cliente> clientes = clienteUseCase.getClientes();
            List<ClienteDTO> clienteDTOS = ClienteMapper.clienteDTOList(clientes);
            return  ResponseEntity.ok().body(new ApiResponse<>(true, "Lista de clientes obtenida exitosamente", clienteDTOS));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al obtener lista de clientes", null));
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCliente(@PathVariable Long id) {
        try {
            var cliente = clienteUseCase.getCliente(id);
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Cliente encontrado", clienteDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Cliente no encontrado con ID: " + id, null));
        }
    }

    @PutMapping(path = "/modificar/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Long id, @RequestBody ClienteResumenDTO dto){
        try {
            Cliente cliente = ClienteMapper.fromDTO(dto);
            cliente.setId(id);
            Cliente clienteActualizado = clienteUseCase.updateCliente(id, cliente);
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(clienteActualizado);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Cliente actualizado", clienteDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al actualizar el cliente", null));
        }
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        try {
            clienteUseCase.deleteCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Cliente eliminado exitosamente", null));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al eliminar el cliente con ID: " + id, null));
        }
    }

}
