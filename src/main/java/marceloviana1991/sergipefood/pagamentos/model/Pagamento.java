package marceloviana1991.sergipefood.pagamentos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoRequestDto;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max=100)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long pedidoId;

    @NotNull
    private Long formaDePagamentoId;

    public Pagamento(PagamentoRequestDto requestDto) {
        this.valor = requestDto.valor();
        this.nome = requestDto.nome();
        this.status = Status.CRIADO;
        this.pedidoId = requestDto.pedidoId();
        this.formaDePagamentoId = requestDto.formaDePagamentoId();
    }

    public void update(PagamentoRequestDto requestDto) {
        if(requestDto.valor() != null) {this.valor = requestDto.valor();}
        if(requestDto.nome() != null) {this.nome = requestDto.nome();}
        if(requestDto.pedidoId() != null) {this.pedidoId = requestDto.pedidoId();}
        if(requestDto.formaDePagamentoId() != null) {this.formaDePagamentoId = requestDto.formaDePagamentoId();}
    }

    public void updateStatusConfirmado() {
        this.status = Status.CONFIRMADO;
    }

    public void updateStatusCancelado() {
        this.status = Status.CANCELADO;
    }
}
