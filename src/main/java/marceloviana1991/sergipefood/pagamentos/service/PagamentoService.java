package marceloviana1991.sergipefood.pagamentos.service;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoResponseDto;
import marceloviana1991.sergipefood.pagamentos.model.Pagamento;
import marceloviana1991.sergipefood.pagamentos.model.Status;
import marceloviana1991.sergipefood.pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

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
    public PagamentoResponseDto aprovaPagamento(Long id) {
        Pagamento pagamento = repository.getReferenceById(id);
        pagamento.setStatus(Status.CONFIRMADO);
        return new PagamentoResponseDto(pagamento);
    }
}
