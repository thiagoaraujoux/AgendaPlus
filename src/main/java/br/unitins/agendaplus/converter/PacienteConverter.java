package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.repository.PacienteRepository;

@Named
@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter<Paciente> {

	@Override
	public Paciente getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		PacienteRepository repo = new PacienteRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Paciente paciente) {
		if (paciente == null || paciente.getId() == null)
			return null;
		return paciente.getId().toString();
	}

}