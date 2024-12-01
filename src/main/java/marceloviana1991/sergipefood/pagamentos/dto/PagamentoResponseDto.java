package marceloviana1991.sergipefood.pagamentos.dto;

import marceloviana1991.sergipefood.pagamentos.model.Pagamento;
import marceloviana1991.sergipefood.pagamentos.model.Status;

import java.math.BigDecimal;

public record PagamentoResponseDto(
        Long id,
        Double valor,
        Status status,
        Long pedidoId
) {
    public PagamentoResponseDto(Pagamento pagamento) {
        this(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getPedidoId()
        );
    }
}
