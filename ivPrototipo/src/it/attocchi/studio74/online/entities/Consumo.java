package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;
import it.attocchi.studio74.online.api.ConsumoAPI.ConsumoTipoEnum;

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
@Table(name = "s74_consumi")
public class Consumo extends AbstractEntityMarksWithIdLong {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cliente_id")
	private long clienteId;
	
	@Column(name = "cliente_descrizione")
	private String clienteDescrizione;

	private String codice;

	// private String tipo;

	private float valore;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String tipo;

	// moduliContratto
	// scadenzaContratto
	//
	// scadenzaConsumo

	// @Temporal(TemporalType.DATE)
	// private Date scadenza;

	// private Accesso accesso;

	// private int valore;
	// private int residuo;
	//
	// private boolean valida;
	//
	// private String clienteRagioneSociale;

	@Column(name = "rivenditore_id")
	private long rivenditoreId;

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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public float getValore() {
		return valore;
	}

	public void setValore(float valore) {
		this.valore = valore;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getRivenditoreId() {
		return rivenditoreId;
	}

	public void setRivenditoreId(long rivenditoreId) {
		this.rivenditoreId = rivenditoreId;
	}

	public String getClienteDescrizione() {
		return clienteDescrizione;
	}

	public void setClienteDescrizione(String clienteDescrizione) {
		this.clienteDescrizione = clienteDescrizione;
	}

	public static Consumo createNew(Nominativo utenteCorrente, ConsumoTipoEnum tipo) {
		Consumo nuovo = new Consumo();

		nuovo.setRivenditoreId(utenteCorrente.getRivenditoreId());

		nuovo.markAsCreated(utenteCorrente.getId());
		nuovo.markAsUpdated(utenteCorrente.getId());
		
		nuovo.setTipo(tipo.name());
		nuovo.setData(new Date());

		return nuovo;
	}
}
