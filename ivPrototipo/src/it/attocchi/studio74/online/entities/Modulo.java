package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;
import it.attocchi.jsf2.converter.ISelectItemConvertible;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s74_moduli")
public class Modulo extends AbstractEntityMarksWithIdLong implements ISelectItemConvertible {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String codice;
	/* valore usato per il consumo */
	private int valore;
	/* indica il nome del programma eseguibile */
	private String programma;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public String getProgramma() {
		return programma;
	}

	public void setProgramma(String programma) {
		this.programma = programma;
	}

	@Override
	public String getItemValue() {
		return String.valueOf(getId());
	}

	@Override
	public String getItemLabel() {
		return getNome();
	}

}
