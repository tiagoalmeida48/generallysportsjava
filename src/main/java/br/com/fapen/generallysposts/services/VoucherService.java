package br.com.fapen.generallysposts.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.fapen.generallysposts.models.Perfil;
import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.models.Voucher;
import br.com.fapen.generallysposts.repositories.Paginacao;
import br.com.fapen.generallysposts.repositories.UsuarioRepository;
import br.com.fapen.generallysposts.repositories.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRep;

    @Autowired
    private UsuarioRepository usuarioRep;

    public Page<Voucher> listar (String busca, Integer pagina, Principal principal) {

        Page<Voucher> listaVoucher;
        boolean isAdmin = false;
		
		for(Perfil p: usuarioRep.findByLogin(principal.getName()).getAuthorities()) {
			if(p.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}

        if(isAdmin){
            if(busca.equals("")) {
               return listaVoucher = voucherRep.findAllByOrderByIdVoucherAsc(Paginacao.getPaginacao(pagina));
            } else {
               return listaVoucher = voucherRep.findAll(Paginacao.getPaginacao(pagina));
            }
        }

        if(busca.equals("")) {
            return listaVoucher = voucherRep.findAllByOrderByIdVoucherAsc(Paginacao.getPaginacao(pagina));
        } else {
           return listaVoucher = voucherRep.findAll(Paginacao.getPaginacao(pagina));
        }
        //    return listaProdutos = produtoRep.findByInativoFalse(Paginacao.getPaginacao(pagina));
       //  } else {
          //  return listaProdutos = produtoRep.findByDescricaoContainingIgnoreCaseAndInativoFalse(busca, Paginacao.getPaginacao(pagina));
        // } 
    }
}
