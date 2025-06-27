package br.com.cotiinformatica.domain.interfaces;

import br.com.cotiinformatica.domain.dto.request.PedidoRequest;
import br.com.cotiinformatica.domain.dto.response.PedidoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PedidoService {

    PedidoResponse criar(PedidoRequest request);

    PedidoResponse alterar(UUID id, PedidoRequest request);

    PedidoResponse excluir(UUID id);

    Page<PedidoResponse> consultar(Pageable pageable);

    PedidoResponse obter(UUID id);
}

