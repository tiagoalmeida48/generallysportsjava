package br.com.fapen.generallysposts.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public Page<Fornecedor> findByRazaoSocialContainingIgnoreCase(String busca, Pageable paginacao);

	public Page<Fornecedor> findAllByOrderById(Pageable paginacao);

	public boolean existsByCnpj(String cnpj);

	public Fornecedor findByCnpj(String cnpj);
	
	public boolean existsByEmail(String email);
	
	public Fornecedor findByEmail(String email);
	
	public Fornecedor findOneById(Long id);

	public Page<Fornecedor> findByInativoFalseOrderByIdAsc(Pageable paginacao);
	
	public Page<Fornecedor> findByRazaoSocialContainingIgnoreCaseAndInativoFalse(String busca, Pageable paginacao);

	public List<Fornecedor> findAllByInativoFalse();
	
}
