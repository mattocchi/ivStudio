package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "s74_postazioni")
public class Postazione extends AbstractEntityMarksWithIdLong {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cliente_id")
	private long clienteId;

	@Column(name = "rivenditore_id")
	private long rivenditoreId;

	/*
	 * Numero Licenza di Quella Partita Iva
	 */
	@Column(name = "licenza_numero")
	private String licenzaNumero;
	@Column(name = "mac_address")
	private String macAddress;
	@Column(name = "nome_pc")
	private String nomePc;
	@Column(name = "sistema_operativo")
	private String sistemaOperativo;
	@Column(name = "utente")
	private String utente;

	@Column(name = "data_registrazione")
	@Temporal(TemporalType.DATE)
	private Date dataRegistrazione;

	@Column(name = "autorizzata")
	private boolean autorizzata;

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

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public long getRivenditoreId() {
		return rivenditoreId;
	}

	public void setRivenditoreId(long rivenditoreId) {
		this.rivenditoreId = rivenditoreId;
	}

	public String getLicenzaNumero() {
		return licenzaNumero;
	}

	public void setLicenzaNumero(String licenzaNumero) {
		this.licenzaNumero = licenzaNumero;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getNomePc() {
		return nomePc;
	}

	public void setNomePc(String nomePc) {
		this.nomePc = nomePc;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public boolean isAutorizzata() {
		return autorizzata;
	}

	public void setAutorizzata(boolean autorizzata) {
		this.autorizzata = autorizzata;
	}

}
