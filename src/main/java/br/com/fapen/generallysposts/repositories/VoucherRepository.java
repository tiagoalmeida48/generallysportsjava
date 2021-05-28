package br.com.fapen.generallysposts.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.generallysposts.models.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

	public Page<Voucher> findAllByOrderByIdVoucherAsc(Pageable paginacao);

	//public Page<Voucher> findByDescricaoContainingIgnoreCase(String busca, Pageable paginacao);

	public Voucher findOneByIdVoucher(Long id);

	public Page<Voucher> findAll(Pageable paginacao);
}
