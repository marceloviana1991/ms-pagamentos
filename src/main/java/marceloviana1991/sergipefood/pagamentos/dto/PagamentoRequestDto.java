package marceloviana1991.sergipefood.pagamentos.dto;

import java.math.BigDecimal;

public record PagamentoRequestDto(
        BigDecimal valor,
        String nome,
        Long pedidoId
) {
}
