package co.floristeria.infrastructure.entry_points.controller;

import co.floristeria.domain.model.pedido.CrearPedido;
import co.floristeria.domain.model.pedido.Pedido;
import co.floristeria.domain.usecase.NotFoundExceptions;
import co.floristeria.domain.usecase.pedido.PedidoUseCase;
import co.floristeria.infrastructure.entry_points.dto.pedido.CrearPedidoDTO;
import co.floristeria.infrastructure.entry_points.dto.pedido.PedidoDTO;
import co.floristeria.infrastructure.entry_points.mapper.PedidoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
class PedidoController {

    private final PedidoUseCase pedidoUseCase;
    public PedidoController(PedidoUseCase pedidoUseCase) {this.pedidoUseCase = pedidoUseCase;}

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPedido(@PathVariable Long id) {
        try {
            var pedido = pedidoUseCase.getPedido(id);
             PedidoDTO dto = PedidoMapper.toPedidoDTO(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Pedido encontrado", dto));
        }catch (NotFoundExceptions.NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<?> listar() {
        try {
            List<Pedido> pedidos = pedidoUseCase.getAllPedidos();
            List<PedidoDTO> pedidosDTO = PedidoMapper.toPedidoDTOList(pedidos);

            ApiResponse<List<PedidoDTO>> response = new ApiResponse<>(true,"Lista de pedidos obtenida exitosamente",pedidosDTO);

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Lista de pedidos obtenida exitosamente", pedidosDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al obtener la lista de pedidos", null));
        }
    }

    @PostMapping(path = "/crear")
    public  ResponseEntity<?> crearPedido(@RequestBody CrearPedidoDTO dto) {
        try {
            CrearPedido pedido = PedidoMapper.toCrearPedido(dto);
            Pedido pedidoCreado = pedidoUseCase.crearPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Pedido Creado", pedidoCreado));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error al crear el pedido", null));
        }

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        try {
            pedidoUseCase.deletePedido(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Pedido eliminado exitosamente", null));
        } catch (NotFoundExceptions.NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }


}
