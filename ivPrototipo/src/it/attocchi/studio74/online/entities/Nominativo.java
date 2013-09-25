package it.attocchi.studio74.online.entities;

import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.EntityMarks;
import it.attocchi.jsf2.converter.ISelectItemConvertible;
import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.api.NominativoAPI.GruppoUtenteEnum;
import it.attocchi.studio74.online.api.NominativoAPI.RuoloContattoEnum;
import it.attocchi.utils.ListUtils;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "s74_nominativi")
@XmlRootElement
public class Nominativo extends AbstractEntityMarksWithIdLong implements ISelectItemConvertible {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "rivenditore_id")
	private long rivenditoreId;

	@Column(name = "codice")
	private String codice;
	@Column(name = "nome_visualizzato")
	private String nomeVisualizzato;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "partita_iva")
	private String partitaIva;
	@Column(name = "ragione_sociale")
	private String ragioneSociale;
	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	@Column(name = "titolo")
	private String titolo;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;

	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;

	@Lob
	@Column(name = "note")
	private String note;

	@Column(name = "contatto_padre_id")
	private long contattoPadreId;

	@Column(name = "ruoli")
	private String ruoli;

	@Column(name = "gruppi")
	private String gruppi;

	@Column(name = "indirizzo_via")
	private String indirizzoVia;
	@Column(name = "indirizzo_cap")
	private String indirizzoCap;
	@Column(name = "indirizzo_comune")
	private String indirizzoComune;
	@Column(name = "indirizzo_prov")
	private String indirizzoProvincia;

	@Column(name = "fattura_via")
	private String fatturaVia;
	@Column(name = "fattura_cap")
	private String fatturaCap;
	@Column(name = "fattura_comune")
	private String fatturaComune;
	@Column(name = "fattura_prov")
	private String fatturaProvincia;

	@Column(name = "telefono")
	private String telefono;
	@Column(name = "fax")
	private String fax;
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;
	@Column(name = "sito")
	private String sito;

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

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	protected Nominativo() {
		super();
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

	public String getNomeVisualizzato() {
		return nomeVisualizzato;
	}

	public void setNomeVisualizzato(String nomeVisualizzato) {
		this.nomeVisualizzato = nomeVisualizzato;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getContattoPadreId() {
		return contattoPadreId;
	}

	public void setContattoPadreId(long contattoPadreId) {
		this.contattoPadreId = contattoPadreId;
	}

	public String getRuoli() {
		return ruoli;
	}

	public void setRuoli(String ruoli) {
		this.ruoli = ruoli;
	}

	public String getGruppi() {
		return gruppi;
	}

	public void setGruppi(String gruppi) {
		this.gruppi = gruppi;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSito() {
		return sito;
	}

	public void setSito(String sito) {
		this.sito = sito;
	}

	public String getIndirizzoVia() {
		return indirizzoVia;
	}

	public void setIndirizzoVia(String indirizzoVia) {
		this.indirizzoVia = indirizzoVia;
	}

	public String getIndirizzoCap() {
		return indirizzoCap;
	}

	public void setIndirizzoCap(String indirizzoCap) {
		this.indirizzoCap = indirizzoCap;
	}

	public String getIndirizzoComune() {
		return indirizzoComune;
	}

	public void setIndirizzoComune(String indirizzoComune) {
		this.indirizzoComune = indirizzoComune;
	}

	public String getIndirizzoProvincia() {
		return indirizzoProvincia;
	}

	public void setIndirizzoProvincia(String indirizzoProvincia) {
		this.indirizzoProvincia = indirizzoProvincia;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFatturaVia() {
		return fatturaVia;
	}

	public void setFatturaVia(String fatturaVia) {
		this.fatturaVia = fatturaVia;
	}

	public String getFatturaCap() {
		return fatturaCap;
	}

	public void setFatturaCap(String fatturaCap) {
		this.fatturaCap = fatturaCap;
	}

	public String getFatturaComune() {
		return fatturaComune;
	}

	public void setFatturaComune(String fatturaComune) {
		this.fatturaComune = fatturaComune;
	}

	public String getFatturaProvincia() {
		return fatturaProvincia;
	}

	public void setFatturaProvincia(String fatturaProvincia) {
		this.fatturaProvincia = fatturaProvincia;
	}

	public void addRuolo(RuoloContattoEnum ruolo) {
		if (StringUtils.isBlank(ruoli))
			ruoli = ruolo.name();
		else
			ruoli = ListUtils.addToListOfString(ruoli, ruolo.name());
	}

	public void addGruppo(GruppoUtenteEnum gruppo) {
		if (StringUtils.isBlank(gruppi))
			gruppi = gruppo.name();
		else
			gruppi = ListUtils.addToListOfString(gruppi, gruppo.name());
	}

	public static Nominativo createNew(long utenteId, long rivenditoreId) {
		Nominativo nuovo = new Nominativo();

		nuovo.setRivenditoreId(rivenditoreId);

		nuovo.markAsCreated(utenteId);
		nuovo.markAsUpdated(utenteId);

		return nuovo;
	}

	public static Nominativo createNew(Nominativo utenteCorrente, NominativoAPI.RuoloContattoEnum ruolo) {
		Nominativo nuovo = new Nominativo();

		nuovo.setRivenditoreId(utenteCorrente.getRivenditoreId());

		nuovo.markAsCreated(utenteCorrente.getId());
		nuovo.markAsUpdated(utenteCorrente.getId());

		nuovo.addRuolo(ruolo);

		return nuovo;
	}

	@Override
	@XmlTransient
	@Transient
	public String getItemLabel() {
		return getNomeVisualizzato();
	}

	@Override
	@XmlTransient
	@Transient
	public String getItemValue() {
		return String.valueOf(getId());
	}
}
