package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Agendamento;
import br.unitins.agendaplus.repository.AgendamentoRepository;

@Named
@FacesConverter(forClass = Agendamento.class)
public class AgendamentoConverter implements Converter<Agendamento> {

	@Override
	public Agendamento getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		AgendamentoRepository repo = new AgendamentoRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Agendamento agendamento) {
		if (agendamento == null || agendamento.getId() == null)
			return null;
		return agendamento.getId().toString();
	}

}