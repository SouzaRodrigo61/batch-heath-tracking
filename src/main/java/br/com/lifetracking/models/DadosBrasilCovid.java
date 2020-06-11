package br.com.lifetracking.models;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Cacheable
@Entity
public class DadosBrasilCovid extends PanacheEntityBase {

	@EmbeddedId
	public DadosBrasilCovidId id;

	@Column
	public String nomeRegiaoSaude;
	
	@Column
	public String semanaEpi;
	
	@Column
	public String populacaoTCU2019;
	
	@Column
	public String casosNovos;
	
	@Column
	public String obitosAcumulado;
	
	@Column
	public String obitosNovos;
	
	@Column
	public String recuperadosNovos;
	
	@Column
	public String emAcompanhamentoNovos;

}
