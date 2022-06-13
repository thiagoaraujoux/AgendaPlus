package br.unitins.agendaplus.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EsqueceuSenha extends DefaultEntity {

	private String codigo;
	@ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	private LocalDateTime dataHoraLimite;
	private Boolean utilizado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataHoraLimite() {
		return dataHoraLimite;
	}

	public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
		this.dataHoraLimite = dataHoraLimite;
	}

	public Boolean getUtilizado() {
		return utilizado;
	}

	public void setUtilizado(Boolean utilizado) {
		this.utilizado = utilizado;
	}

}
