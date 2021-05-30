package br.com.fapen.generallysposts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.models.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

	public Page<Voucher> findAllByOrderByIdVoucherAsc(Pageable paginacao);

	//public Page<Voucher> findByDescricaoContainingIgnoreCase(String busca, Pageable paginacao);

	public Voucher findOneByIdVoucher(Long id);

	public Page<Voucher> findAll(Pageable paginacao);
	
	public Page<Voucher> findByInativoFalse(Pageable paginacao);

	public List<Voucher> findAllByInativoFalse();
	
	@Query(value = "SELECT * FROM tb_voucher WHERE inativo = 'false'", nativeQuery = true)
	public List<Voucher> findAllByInativoFalseAndEstoque();


}
