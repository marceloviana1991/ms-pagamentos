package marceloviana1991.sergipefood.pagamentos.amqp;

import marceloviana1991.sergipefood.pagamentos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoResponseDto;
import marceloviana1991.sergipefood.pagamentos.service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    @Autowired
    private PagamentoService service;

    @RabbitListener(queues = "pedido.registrado")
    public void recebeMensagem(PagamentoRequestDto requestDto) {
        PagamentoResponseDto responseDto = service.savePagamento(requestDto);
        System.out.println(responseDto);
    }
}
