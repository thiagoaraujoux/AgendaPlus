package br.unitins.agendaplus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Cidade;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.repository.CidadeRepository;
import br.unitins.agendaplus.repository.MedicoRepository;

@Named
@FacesConverter(forClass = Medico.class)
public class MedicoConverter implements Converter<Medico> {

	@Override
	public Medico getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		MedicoRepository repo = new MedicoRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Medico medico) {
		if (medico == null || medico.getId() == null)
			return null;
		return medico.getId().toString();
	}

}