package br.com.cotiinformatica.domain.dto.response;

import br.com.cotiinformatica.domain.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PedidoResponse {
    private UUID id;
    private String cliente;
    private String dataHora;
    private Double valor;
    private StatusPedidoResponse status;
}
