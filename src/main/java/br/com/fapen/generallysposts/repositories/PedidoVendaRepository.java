package br.com.fapen.generallysposts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.generallysposts.models.PedidoVenda;
import br.com.fapen.generallysposts.models.Usuario;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {

	public List<PedidoVenda> findAllByUsuario(Usuario usuario);
}
