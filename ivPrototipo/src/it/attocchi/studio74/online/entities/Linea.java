package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;
import it.attocchi.jsf2.converter.ISelectItemConvertible;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "s74_linee")
public class Linea extends AbstractEntityMarksWithIdLong implements ISelectItemConvertible {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String codice;

	/**
	 * Indice di posizione del bit che attiva la linea nella chiave di licenza
	 */
	private int idChiave;

	private String gruppo;

	/* elenco dei moduli associati a questa linea */
	private String moduli;

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

	public String getModuli() {
		return moduli;
	}

	public void setModuli(String moduli) {
		this.moduli = moduli;
	}

	public void addModulo(Modulo modulo) {
		if (StringUtils.isBlank(moduli))
			moduli = ListUtils.toCommaSepared(new ArrayList<Long>());

		moduli = ListUtils.addToListOfLong(moduli, modulo.getId());
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public String getItemLabel() {
		return this.getNome();
	}

	@Override
	public String getItemValue() {
		return String.valueOf(this.getId());
	}

	public int getIdChiave() {
		return idChiave;
	}

	public void setIdChiave(int idChiave) {
		this.idChiave = idChiave;
	}

}
