package br.unitins.agendaplus.model;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class DefaultEntity<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Version
	private Integer version;

	private LocalDateTime dataCadastro;

	private LocalDateTime dataAlteracao;

	@PrePersist
	private void gerarDataCadastro() {
		dataCadastro = LocalDateTime.now();
	}

	@PreUpdate
	private void gerarDataAlteracao() {
		dataAlteracao = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
