package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.api.CrudApi;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.NominativoFiltro;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public class NominativoAPI extends CrudApi<Nominativo> {

	public enum RuoloContattoEnum {
		RIVENDITORE,
		UTENTE,
		CONTATTO
	}

	public enum GruppoUtenteEnum {
		ADMIN
	}

	public Nominativo creaNuovo(EntityManagerFactory emf, Nominativo utenteLoggato, RuoloContattoEnum ruolo) {
		Nominativo contatto = Nominativo.createNew(utenteLoggato.getId(), utenteLoggato.getRivenditoreId());

		contatto.addRuolo(ruolo);

		return contatto;
	}

	public Nominativo salva(EntityManagerFactory emf, Nominativo utenteLoggato, Nominativo contattoDaSalvare) throws Exception {

		contattoDaSalvare.setNomeVisualizzato(contattoDaSalvare.getRagioneSociale());

		contattoDaSalvare.markAsUpdated(utenteLoggato.getId());

		if (contattoDaSalvare.getId() > 0)
			JpaController.callUpdate(emf, contattoDaSalvare);
		else
			JpaController.callInsert(emf, contattoDaSalvare);

		return JpaController.callFindById(emf, Nominativo.class, contattoDaSalvare.getId());
	}

	public List<GruppoUtenteEnum> gruppiUtente(Nominativo currentUser) {
		List<GruppoUtenteEnum> res = new ArrayList<GruppoUtenteEnum>();

		List<String> gruppi = ListUtils.fromCommaSepared(currentUser.getGruppi());
		for (String gruppo : gruppi) {
			for (GruppoUtenteEnum e : GruppoUtenteEnum.values()) {
				if (e.name().equals(gruppo)) {
					res.add(e);
				}
			}
		}

		return res;
	}

	public List<Nominativo> listaContatti(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Nominativo.class, new NominativoFiltro(RuoloContattoEnum.CONTATTO));
	}

	public Nominativo cerca(EntityManagerFactory emf, long clienteId) throws Exception {
		Nominativo res = JpaController.callFindById(emf, Nominativo.class, clienteId);
		return res;
	}
}
