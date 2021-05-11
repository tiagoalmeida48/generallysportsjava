package br.com.fapen.generallysposts.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.CarrinhoCompra;

@Repository
public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "select tb_carrinho_compra.id_carrinho, tb_carrinho_compra.id_usuario, tb_carrinho_compra.quantidade_carrinho, tb_produto.* from tb_carrinho_compra inner join tb_produto on tb_carrinho_compra.id_produto = tb_produto.id_produto where tb_carrinho_compra.id_usuario = :idUsuario", nativeQuery = true)
	public List<CarrinhoCompra> findByIdUsuario(@Param("idUsuario") Long usuario);

	
}
