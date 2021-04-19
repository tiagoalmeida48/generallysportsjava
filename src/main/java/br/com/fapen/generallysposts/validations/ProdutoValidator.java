package br.com.fapen.generallysposts.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.generallysposts.models.Produto;

@Component
public class ProdutoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeProduto", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fornecedor", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custoUnitario", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precoVenda", "campo.obrigatorio");
	}
}
