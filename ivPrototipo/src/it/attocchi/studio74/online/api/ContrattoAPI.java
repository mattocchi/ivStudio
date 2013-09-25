package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.entities.Attivita;
import it.attocchi.studio74.online.entities.Licenza;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.AttivitaFiltro;
import it.attocchi.utils.DateUtilsLT;
import it.attocchi.utils.ListUtils;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public class ContrattoAPI extends S74Crud<Attivita> {

	public List<Attivita> lista(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Attivita.class, new AttivitaFiltro());
	}

	public Attivita rinnovoPrepara(EntityManagerFactory emf, Nominativo currentUser, long idRinnovo) throws Exception {
		Attivita rinnovato = null;

		Attivita contrattoDaRinnovare = JpaController.callFindById(emf, Attivita.class, idRinnovo);

		if (contrattoDaRinnovare != null) {
			rinnovato = new ContrattoAPI().nuovo(currentUser, contrattoDaRinnovare.getLicenzaNumero());

			rinnovato.setCanoneDataInizio(DateUtilsLT.addDays(contrattoDaRinnovare.getCanoneDataFine(), 1));
			rinnovato.setCanoneDataFine(DateUtilsLT.addDays(contrattoDaRinnovare.getCanoneDataFine(), 365));

			rinnovato.setClienteId(contrattoDaRinnovare.getClienteId());

			Nominativo cliente = JpaController.callFindById(emf, Nominativo.class, contrattoDaRinnovare.getClienteId());
			if (cliente != null) {
				rinnovato.setClienteDescrizione(cliente.getNomeVisualizzato());
			}
			rinnovato.setContrattoPadreId(idRinnovo);
			rinnovato.setLinee(contrattoDaRinnovare.getLinee());
		}

		return rinnovato;

	}

	public void rinnovoSalva(EntityManagerFactory emf, Nominativo currentUser, Attivita rinnovata, List<String> lineeId) throws Exception {

		salva(emf, currentUser, rinnovata, lineeId);

		Attivita obsoleta = JpaController.callFindById(emf, Attivita.class, rinnovata.getContrattoPadreId());
		obsoleta.setObsoleto(true);

		JpaController.callUpdate(emf, obsoleta);

	}

	public void salva(EntityManagerFactory emf, Nominativo currentUser, Attivita elemento, List<String> lineeId) throws Exception {
		elemento.setLinee(ListUtils.toCommaSepared(lineeId));
		salva(emf, currentUser, elemento);
	}

	public List<Attivita> listaByCliente(EntityManagerFactory emf, Nominativo currentUser, long idCliente) throws Exception {
		AttivitaFiltro f = new AttivitaFiltro();
		f.setClienteId(idCliente);
		return JpaController.callFind(emf, Attivita.class, f);
	}

	public List<Attivita> listaRecenti(EntityManagerFactory emf, Nominativo currentUser, int limite) throws Exception {
		AttivitaFiltro filtro = new AttivitaFiltro();
		filtro.setLimit(limite);
		return JpaController.callFind(emf, Attivita.class, filtro);
	}

	@Override
	public void salvaPre(EntityManagerFactory emf, Nominativo utente, Attivita elemento) throws Exception {
		Nominativo cliente = new NominativoAPI().cerca(emf, elemento.getClienteId());
		elemento.setClienteDescrizione(cliente.getNomeVisualizzato());
	}

	@Override
	public void salvaPost(EntityManagerFactory emf, Nominativo utente, Attivita elemento, boolean nuovoInserimento) throws Exception {
		if (nuovoInserimento) {
			/* Creaiamo la nuova postazione di default per questo contratto */
			LicenzaAPI postazioneApi = new LicenzaAPI();
			Licenza postazione = postazioneApi.crea(emf, utente, elemento.getClienteId(), 1, LicenzaAPI.LicenzaTipoEnum.DESKTOP);

			postazioneApi.salva(emf, utente, postazione);
		}
	}

	public Attivita nuovo(Nominativo utenteCorrente, long licenzaNumero) {
		Attivita nuovo = new Attivita();

		nuovo.setRivenditoreId(utenteCorrente.getRivenditoreId());

		nuovo.markAsCreated(utenteCorrente.getId());
		nuovo.markAsUpdated(utenteCorrente.getId());

		nuovo.setLicenzaNumero(licenzaNumero);

		Date now = DateUtilsLT.Now();
		int annoCorrente = DateUtilsLT.getYearAsInt(now);
		nuovo.setCanoneDataInizio(DateUtilsLT.getDate(annoCorrente, 0, 1, 00, 01));
		nuovo.setCanoneDataFine(DateUtilsLT.getDate(annoCorrente, 11, 31, 23, 59));

		nuovo.setAggiornamentoAttivo(true);

		nuovo.setConsumoDataInizio(now);
		nuovo.setConsumoDataFine(DateUtilsLT.addDays(now, 365 + 30));

		nuovo.setFirmato(true);

		String ultimaVersione = ""; // TODO: Calcolare l'ultima versione
									// dall'elenco
		nuovo.setVersione(ultimaVersione);

		return nuovo;
	}
}
