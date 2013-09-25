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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "s74_contratti")
public class Attivita extends AbstractEntityMarksWithIdLong {

	// protected Contratto() {
	// super();
	// }

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

	@Column(name = "contratto_padre_id")
	private long contrattoPadreId;

	@Column(name = "obsoleto")
	private boolean obsoleto;

	@Column(name = "data_inizio")
	@Temporal(TemporalType.DATE)
	private Date canoneDataInizio;
	@Column(name = "data_fine")
	@Temporal(TemporalType.DATE)
	private Date canoneDataFine;

	@Column(name = "linee")
	@Lob
	private String linee;

	@Column(name = "consumo_data_inizio")
	@Temporal(TemporalType.DATE)
	private Date consumoDataInizio;
	@Column(name = "consumo_data_fine")
	@Temporal(TemporalType.DATE)
	private Date consumoDataFine;

	@Column(name = "fitmato")
	private boolean firmato;
	@Column(name = "versione")
	private String versione;

	@Column(name = "descrizione")
	@Lob
	private String descrizione;

	@Column(name = "tipologia")
	private String tipologia;

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

	public long getLicenzaNumero() {
		return licenzaNumero;
	}

	public void setLicenzaNumero(long licenzaNumero) {
		this.licenzaNumero = licenzaNumero;
	}

	public String getLinee() {
		return linee;
	}

	public void setLinee(String linee) {
		this.linee = linee;
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

	public long getContrattoPadreId() {
		return contrattoPadreId;
	}

	public void setContrattoPadreId(long contrattoPadreId) {
		this.contrattoPadreId = contrattoPadreId;
	}

	public boolean isScaduto() {
		return canoneDataFine != null && new Date().getTime() - canoneDataFine.getTime() > 0;
	}

	public boolean isObsoleto() {
		return obsoleto;
	}

	public void setObsoleto(boolean obsoleto) {
		this.obsoleto = obsoleto;
	}

	@Column(name = "sospeso")
	private boolean sospeso;

	@Column(name = "aggiornamento_attivo")
	private boolean aggiornamentoAttivo;

	@Column(name = "consumo_attivo")
	private boolean consumoAttivo;

	@Column(name = "canone_attivo")
	private boolean canoneAttivo;

	public boolean isSospeso() {
		return sospeso;
	}

	public void setSospeso(boolean sospeso) {
		this.sospeso = sospeso;
	}

	public boolean isAggiornamentoAttivo() {
		return aggiornamentoAttivo;
	}

	public void setAggiornamentoAttivo(boolean aggiornamentoAttivo) {
		this.aggiornamentoAttivo = aggiornamentoAttivo;
	}

	public boolean isConsumoAttivo() {
		return consumoAttivo;
	}

	public void setConsumoAttivo(boolean consumoAttivo) {
		this.consumoAttivo = consumoAttivo;
	}

	public boolean isCanoneAttivo() {
		return canoneAttivo;
	}

	public void setCanoneAttivo(boolean canoneAttivo) {
		this.canoneAttivo = canoneAttivo;
	}

	public Date getCanoneDataInizio() {
		return canoneDataInizio;
	}

	public void setCanoneDataInizio(Date canoneDataInizio) {
		this.canoneDataInizio = canoneDataInizio;
	}

	public Date getCanoneDataFine() {
		return canoneDataFine;
	}

	public void setCanoneDataFine(Date canoneDataFine) {
		this.canoneDataFine = canoneDataFine;
	}

	public Date getConsumoDataInizio() {
		return consumoDataInizio;
	}

	public void setConsumoDataInizio(Date consumoDataInizio) {
		this.consumoDataInizio = consumoDataInizio;
	}

	public Date getConsumoDataFine() {
		return consumoDataFine;
	}

	public void setConsumoDataFine(Date consumoDataFine) {
		this.consumoDataFine = consumoDataFine;
	}

	public boolean isFirmato() {
		return firmato;
	}

	public void setFirmato(boolean firmato) {
		this.firmato = firmato;
	}

	public String getVersione() {
		return versione;
	}

	public void setVersione(String versione) {
		this.versione = versione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
