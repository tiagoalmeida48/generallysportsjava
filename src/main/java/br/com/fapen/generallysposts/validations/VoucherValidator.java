package br.com.fapen.generallysposts.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.generallysposts.models.Voucher;

@Component
public class VoucherValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Voucher.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precoVenda", "campo.obrigatorio");
}

}