package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.repository.AtendenteRepository;

@Named
@FacesConverter(forClass = Atendente.class)
public class AtendenteConverter implements Converter<Atendente> {

	@Override
	public Atendente getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		AtendenteRepository repo = new AtendenteRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Atendente atendente) {
		if (atendente == null || atendente.getId() == null)
			return null;
		return atendente.getId().toString();
	}

}