package marceloviana1991.sergipefood.pagamentos.dto;

public record PagamentoRequestDto(
        Double valor,
        Long pedidoId
) {
}
