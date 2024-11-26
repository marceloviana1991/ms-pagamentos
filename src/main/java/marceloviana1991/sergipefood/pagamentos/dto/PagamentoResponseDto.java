package marceloviana1991.sergipefood.pagamentos.dto;

import marceloviana1991.sergipefood.pagamentos.model.Pagamento;
import marceloviana1991.sergipefood.pagamentos.model.Status;

import java.math.BigDecimal;

public record PagamentoResponseDto(
        Long id,
        BigDecimal valor,
        String nome,
        Status status,
        Long pedidoId,
        Long formaDePagamentoId
) {
    public PagamentoResponseDto(Pagamento pagamento) {
        this(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getNome(),
                pagamento.getStatus(),
                pagamento.getPedidoId(),
                pagamento.getFormaDePagamentoId()
        );
    }
}
