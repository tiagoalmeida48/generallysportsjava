package br.com.fapen.generallysposts.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.generallysposts.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Page<Pessoa> findAllByOrderByIdPessoaAsc(Pageable paginacao);
	
	public Page<Pessoa> findByNomeContainingIgnoreCase(String busca, Pageable paginacao);
}
