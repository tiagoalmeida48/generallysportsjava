package br.com.fapen.generallysposts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Page<Produto> findByDescricaoContainingIgnoreCase(String busca, Pageable paginacao);
	
	public Page<Produto> findByDescricaoContainingIgnoreCaseAndInativoFalse(String busca, Pageable paginacao);

	public Page<Produto> findAllByOrderByIdProdutoAsc(Pageable paginacao);
	
	public Produto findOneByIdProduto(Long id);

	public Page<Produto> findByInativoFalse(Pageable paginacao);

	public List<Produto> findAllByInativoFalse();
	
	@Query(value = "SELECT * FROM tb_produto WHERE inativo = 'false' AND quantidade_estoque > 0", nativeQuery = true)
	public List<Produto> findAllByInativoFalseAndEstoque();

	@Query(value = "SELECT * FROM tb_produto WHERE inativo = 'false' AND quantidade_estoque > 0 AND categoria = :categoria", nativeQuery = true)
	public List<Produto> findAllByInativoFalseAndEstoqueAndCategoria(@Param("categoria") String categoria);

	public Page<Produto> findAll(Pageable paginacao);

}
