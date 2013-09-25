package it.attocchi.studio74.online.stat;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;
import it.attocchi.studio74.online.api.ConsumoAPI;
import it.attocchi.studio74.online.api.ContrattoAPI;
import it.attocchi.studio74.online.api.LicenzaAPI;
import it.attocchi.studio74.online.api.NotaAPI;
import it.attocchi.studio74.online.api.NotaAPI.NotaTipoEnum;
import it.attocchi.studio74.online.api.PostazioneAPI;
import it.attocchi.studio74.online.entities.Consumo;
import it.attocchi.studio74.online.entities.Contratto;
import it.attocchi.studio74.online.entities.Licenza;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.Nota;
import it.attocchi.studio74.online.entities.Postazione;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public class StatoCliente {
	private List<Contratto> contratti;
	private List<Consumo> consumi;
	private List<Licenza> licenze;
	private List<Postazione> postazioni;
	private float consumoUsato;
	private float consumoCredito;
	private float consumoResiduo;
	private float consumoResiduoPerc;
	private int licenzeTot;
	private int postazioniCount;

	List<Nota> note;
	List<Nota> noteAssistenza;

	public List<Contratto> getContratti() {
		return contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public List<Consumo> getConsumi() {
		return consumi;
	}

	public void setConsumi(List<Consumo> consumi) {
		this.consumi = consumi;
	}

	public List<Licenza> getLicenze() {
		return licenze;
	}

	public void setLicenze(List<Licenza> licenze) {
		this.licenze = licenze;
	}

	public List<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(List<Postazione> postazioni) {
		this.postazioni = postazioni;
	}

	public float getConsumoUsato() {
		return consumoUsato;
	}

	public void setConsumoUsato(float consumoUsato) {
		this.consumoUsato = consumoUsato;
	}

	public float getConsumoCredito() {
		return consumoCredito;
	}

	public void setConsumoCredito(float consumoCredito) {
		this.consumoCredito = consumoCredito;
	}

	public float getConsumoResiduo() {
		return consumoResiduo;
	}

	public void setConsumoResiduo(float consumoResiduo) {
		this.consumoResiduo = consumoResiduo;
	}

	public float getConsumoResiduoPerc() {
		return consumoResiduoPerc;
	}

	public void setConsumoResiduoPerc(float consumoResiduoPerc) {
		this.consumoResiduoPerc = consumoResiduoPerc;
	}

	public int getLicenzeTot() {
		return licenzeTot;
	}

	public void setLicenzeTot(int licenzeTot) {
		this.licenzeTot = licenzeTot;
	}

	public int getPostazioniCount() {
		return postazioniCount;
	}

	public void setPostazioniCount(int postazioniCount) {
		this.postazioniCount = postazioniCount;
	}

	public List<Nota> getNote() {
		return note;
	}

	public void setNote(List<Nota> note) {
		this.note = note;
	}

	public List<Nota> getNoteAssistenza() {
		return noteAssistenza;
	}

	public void setNoteAssistenza(List<Nota> noteAssistenza) {
		this.noteAssistenza = noteAssistenza;
	}

	public void calcola(EntityManagerFactory emf, Nominativo utenteCorrente, long idCliente) throws Exception {
		if (idCliente > 0) {
			contratti = new ContrattoAPI().listaByCliente(emf, utenteCorrente, idCliente);
			consumi = new ConsumoAPI().listaByCliente(emf, utenteCorrente, idCliente);
			licenze = new LicenzaAPI().listaByCliente(emf, utenteCorrente, idCliente);
			postazioni = new PostazioneAPI().listaByCliente(emf, utenteCorrente, idCliente);

			for (Consumo consumo : consumi) {
				if (consumo.getTipo().equals(ConsumoAPI.ConsumoTipoEnum.CONSUMO.name()))
					consumoUsato = consumoUsato + Math.abs(consumo.getValore());
				else
					consumoCredito = consumoCredito + consumo.getValore();
			}

			consumoResiduo = consumoCredito - consumoUsato;
			consumoResiduoPerc = 100 - ((consumoUsato / consumoCredito) * 100);

			note = new NotaAPI().lista(emf, utenteCorrente, Nominativo.class, idCliente);
			noteAssistenza = new NotaAPI().lista(emf, utenteCorrente, Nominativo.class, idCliente, NotaTipoEnum.ASSISTENZA);

			/* Conteggi */
			postazioniCount = filter(having(on(Postazione.class).isAutorizzata(), equalTo(true)), postazioni).size();
			licenzeTot = sum(licenze, on(Licenza.class).getNumeroPostazioni());
		}
	}
}
