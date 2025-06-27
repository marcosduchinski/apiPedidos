package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.dto.request.PedidoRequest;
import br.com.cotiinformatica.domain.dto.response.PedidoResponse;
import br.com.cotiinformatica.domain.entity.Pedido;
import br.com.cotiinformatica.domain.exceptions.PedidoNaoEncontradoException;
import br.com.cotiinformatica.domain.interfaces.PedidoService;
import br.com.cotiinformatica.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoResponse criar(PedidoRequest request) {
        var pedido = modelMapper.map(request, Pedido.class);
        pedidoRepository.save(pedido);
        return modelMapper.map(pedido, PedidoResponse.class);
    }

    @Override
    public PedidoResponse alterar(UUID id, PedidoRequest request) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new
                        PedidoNaoEncontradoException(id));
        modelMapper.map(request, pedido);
        pedidoRepository.save(pedido);
        return modelMapper.map(pedido, PedidoResponse.class);
    }

    @Override
    public PedidoResponse excluir(UUID id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()
                        -> new PedidoNaoEncontradoException(id));
        pedidoRepository.delete(pedido);
        return modelMapper.map(pedido, PedidoResponse.class);
    }

    @Override
    public Page<PedidoResponse> consultar(Pageable pageable) {
        var pedidos = pedidoRepository.findAll(pageable);
        return pedidos.map(pedido -> modelMapper
                .map(pedido, PedidoResponse.class));
    }

    @Override
    public PedidoResponse obter(UUID id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()
                        -> new PedidoNaoEncontradoException(id));
        return modelMapper.map(pedido, PedidoResponse.class);
    }
}
