package br.com.fapen.generallysposts.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fapen.generallysposts.enums.StatusPedidoEnum;
import br.com.fapen.generallysposts.models.PedidoCompra;

public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Long> {

	public Page<PedidoCompra> findAllByIdPedido(Long id, Pageable paginacao);

	public Page<PedidoCompra> findAllByOrderByIdPedidoAsc(Pageable paginacao);
	
	public Page<PedidoCompra> findAllBySituacaoPedidoAndInativoFalse(StatusPedidoEnum status, Pageable paginacao);
	
	public Page<PedidoCompra> findAllBySituacaoPedido(StatusPedidoEnum status, Pageable paginacao);
	
	public Page<PedidoCompra> findAllByDtEntregaBetween(LocalDate dataInicial, LocalDate dataFinal, Pageable paginacao);
	
	public Page<PedidoCompra> findAllByInativoFalse(Pageable paginacao);
	
	public Page<PedidoCompra> findAllByFornecedorRazaoSocialContainingIgnoreCase(String busca, Pageable paginacao);
	
	
	// Precisa arrumar
	@Query(value = "select * from tb_pedido_compra where situacao_pedido = 'EM_DIGITACAO' and inativo = false",
			nativeQuery = true)
	public List<PedidoCompra> findAllBySituacaoPedidoEmDigitacaoAndInativoFalse();
}
