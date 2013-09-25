package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s74_voci_elenco")
public class VoceElenco extends AbstractEntityMarksWithIdLong {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "rivenditore_id")
	private long rivenditoreId;

	@Column(name = "codice")
	private String codice;

	@Column(name = "elenco")
	private String elenco;

	@Column(name = "etichetta")
	private String etichetta;
	@Column(name = "valore")
	private String valore;

	@Column(name = "ordinamento")
	private int ordinamento;

	@Column(name = "predefinito")
	private boolean predefinito;

	@Embedded
	private EntityMarks entityMarks;

	@Override
	public EntityMarks getEntityMarks() {
		return entityMarks;
	}

	@Override
	public void setEntityMarks(EntityMarks entityMarks) {
		this.entityMarks = entityMarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRivenditoreId() {
		return rivenditoreId;
	}

	public void setRivenditoreId(long rivenditoreId) {
		this.rivenditoreId = rivenditoreId;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}

	public String getEtichetta() {
		return etichetta;
	}

	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public int getOrdinamento() {
		return ordinamento;
	}

	public void setOrdinamento(int ordinamento) {
		this.ordinamento = ordinamento;
	}

	public boolean isPredefinito() {
		return predefinito;
	}

	public void setPredefinito(boolean predefinito) {
		this.predefinito = predefinito;
	}

}
