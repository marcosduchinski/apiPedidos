package br.com.cotiinformatica.controller;

import br.com.cotiinformatica.domain.dto.request.PedidoRequest;
import br.com.cotiinformatica.domain.dto.response.PedidoResponse;
import br.com.cotiinformatica.domain.interfaces.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(
        name = "Controle de pedidos",
        description = "Serviços para gerenciamento de solicitações de pedidos."
)
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(
            summary = "Cadastro de solicitação de pedido.",
            description = "Cria uma nova solicitação de pedido no sistema."
    )
    @PostMapping
    public ResponseEntity<PedidoResponse> post
            (@RequestBody @Valid PedidoRequest request) {
        var response = pedidoService.criar(request);
        return ResponseEntity.status
                (HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Alteração de solicitação de pedido.",
            description = "Modifica uma solicitação de pedido ja existente no sistema."
    )
    @PutMapping("{id}")
    public ResponseEntity<PedidoResponse> put(@PathVariable UUID id,
                                              @RequestBody @Valid PedidoRequest request) {
        var response = pedidoService.alterar(id, request);
        return ResponseEntity.status
                (HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Exclusão de solicitação de pedido.",
            description = "Remove uma solicitação de pedido já no sistema."
    )
    @DeleteMapping("{id}")
    public ResponseEntity<PedidoResponse> delete
            (@PathVariable UUID id) {
        var response = pedidoService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Consulta de solicitações de pedido.",
            description = "Retorna uma lista contendo solicitações de pedidos cadastrados no sistema."
    )
    @GetMapping
    public ResponseEntity<Page<PedidoResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        var pageable = PageRequest.of
                (page, size, Sort.by(sortBy));
        var response = pedidoService.consultar(pageable);
        return ResponseEntity.status
                (HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Obter solicitação de pedido por id.",
            description = "Retorna um pedidos através do ID informado."
    )
    @GetMapping("{id}")
    public ResponseEntity<PedidoResponse> getById
            (@PathVariable UUID id) {
        var response = pedidoService.obter(id);
        return ResponseEntity.status
                (HttpStatus.OK).body(response);
    }
}
