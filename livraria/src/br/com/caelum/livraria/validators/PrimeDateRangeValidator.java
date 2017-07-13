package br.com.caelum.livraria.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("DataValidator")
public class PrimeDateRangeValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if(value ==null){
			return;
		}
		
		Object dataInicioValor = component.getAttributes().get("dataInicio");
		if(dataInicioValor==null){
			return;
		}
		
		Date dataInicio = (Date)dataInicioValor;
		Date dataFim = (Date)value;
		if(dataFim.before(dataInicio)){
			FacesMessage fm = new FacesMessage("A data de inicio deve menor que a data final");
			throw new ValidatorException(fm);
		}
	}

}
