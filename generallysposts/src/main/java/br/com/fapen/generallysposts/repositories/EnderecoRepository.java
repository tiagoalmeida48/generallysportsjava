package br.com.fapen.generallysposts.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
