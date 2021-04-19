package br.com.fapen.generallysposts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.CarrinhoCompra;

@Repository
public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
	
	public List<CarrinhoCompra> findByIdUsuario(Long usuario);
}
