package br.com.fapen.generallysposts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.ProdutoFavorito;

@Repository
public interface ProdutoFavoritoRepository extends JpaRepository<ProdutoFavorito, Long> {
	
	public List<ProdutoFavorito> findByIdUsuario(Long usuario);
}
