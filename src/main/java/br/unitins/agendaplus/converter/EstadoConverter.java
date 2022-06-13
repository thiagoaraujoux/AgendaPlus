package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Estado;
import br.unitins.agendaplus.repository.EstadoRepository;

@Named
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter<Estado> {

	@Override
	public Estado getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		EstadoRepository repo = new EstadoRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Estado estado) {
		if (estado == null || estado.getId() == null)
			return null;
		return estado.getId().toString();
	}

}