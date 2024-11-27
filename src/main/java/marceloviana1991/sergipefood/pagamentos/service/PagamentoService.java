package marceloviana1991.sergipefood.pagamentos.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoResponseDto;
import marceloviana1991.sergipefood.pagamentos.http.PedidoClient;
import marceloviana1991.sergipefood.pagamentos.model.Pagamento;
import marceloviana1991.sergipefood.pagamentos.model.Status;
import marceloviana1991.sergipefood.pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PedidoClient pedido;

    public List<PagamentoResponseDto> getPagePagamentos(Pageable pageable) {
        return repository.findAll(pageable).stream().map(PagamentoResponseDto::new).toList();
    }

    public PagamentoResponseDto getPagamento(Long id) {
        return new PagamentoResponseDto(repository.getReferenceById(id));
    }

    @Transactional
    public PagamentoResponseDto savePagamento(PagamentoRequestDto requestDto) {
        Pagamento pagamento = new Pagamento(requestDto);
        repository.save(pagamento);
        return new PagamentoResponseDto(pagamento);
    }

    @Transactional
    public PagamentoResponseDto updatePagamento(Long id, PagamentoRequestDto requestDto) {
        Pagamento pagamento = repository.getReferenceById(id);
        pagamento.update(requestDto);
        return new PagamentoResponseDto(pagamento);
    }

    @Transactional
    public PagamentoResponseDto updateStatusConfirmadoPagamento(Long id) {
        Pagamento pagamento = repository.getReferenceById(id);
        pagamento.updateStatusConfirmado();
        return new PagamentoResponseDto(pagamento);
    }

    @Transactional
    public PagamentoResponseDto updateStatusCanceladoPagamento(Long id) {
        Pagamento pagamento = repository.getReferenceById(id);
        pagamento.updateStatusCancelado();
        return new PagamentoResponseDto(pagamento);
    }

    @Transactional
    public void deletePagamento(Long id) {
        repository.deleteById(id);
    }

    public void confirmarPagamento(Long id){
        Optional<Pagamento> pagamento = repository.findById(id);
        if (pagamento.isEmpty()) {
            throw new EntityNotFoundException();
        }
        pagamento.get().setStatus(Status.CONFIRMADO);
        repository.save(pagamento.get());
        pedido.aprovaPagamento(pagamento.get().getPedidoId());
    }
}
