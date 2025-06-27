package br.com.cotiinformatica.handlers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroResponse {
    private String code;
    private String message;
}