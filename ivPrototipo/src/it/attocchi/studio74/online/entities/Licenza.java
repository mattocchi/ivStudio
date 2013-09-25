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
@Table(name = "s74_licenze")
public class Licenza extends AbstractEntityMarksWithIdLong {

	/*
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cliente_id")
	private long clienteId;

	@Column(name = "cliente_desc")
	private String clienteDescrizione;

	@Column(name = "rivenditore_id")
	private long rivenditoreId;

	@Column(name = "licenza_numero")
	private long licenzaNumero;

	@Column(name = "numero_postazioni")
	private int numeroPostazioni;

	@Column(name = "tipo")
	private String tipo;
	
	/*
	 * Date
	 */

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

	/*
	 * Proprieta'
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteDescrizione() {
		return clienteDescrizione;
	}

	public void setClienteDescrizione(String clienteDescrizione) {
		this.clienteDescrizione = clienteDescrizione;
	}

	public long getRivenditoreId() {
		return rivenditoreId;
	}

	public void setRivenditoreId(long rivenditoreId) {
		this.rivenditoreId = rivenditoreId;
	}

	public long getLicenzaNumero() {
		return licenzaNumero;
	}

	public void setLicenzaNumero(long licenzaNumero) {
		this.licenzaNumero = licenzaNumero;
	}

	public int getNumeroPostazioni() {
		return numeroPostazioni;
	}

	public void setNumeroPostazioni(int numeroPostazioni) {
		this.numeroPostazioni = numeroPostazioni;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/*
	 * Metodi
	 */

}
