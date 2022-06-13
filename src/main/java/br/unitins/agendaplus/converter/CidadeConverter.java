package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Cidade;
import br.unitins.agendaplus.repository.CidadeRepository;

@Named
@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter<Cidade> {

	@Override
	public Cidade getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		CidadeRepository repo = new CidadeRepository();
		try {
			return repo.findById(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Cidade cidade) {
		if (cidade == null || cidade.getId() == null)
			return null;
		return cidade.getId().toString();
	}

}