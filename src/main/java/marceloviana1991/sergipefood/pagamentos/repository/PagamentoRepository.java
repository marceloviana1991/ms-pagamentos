package marceloviana1991.sergipefood.pagamentos.repository;

import marceloviana1991.sergipefood.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Pagamento getByPedidoId(Long id);
}
