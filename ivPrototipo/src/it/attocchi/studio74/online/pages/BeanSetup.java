package it.attocchi.studio74.online.pages;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.api.DemoData;
import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.api.NominativoAPI.RuoloContattoEnum;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.NominativoFiltro;
import it.attocchi.studio74.online.jsf.PageBaseS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanSetup extends PageBaseS74 {

	@Override
	protected void preInit() throws PageAuthException {

	}

	@Override
	protected void init() throws Exception {

	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	@Override
	protected void init2() throws Exception {

	}

	public String actionSetup() {

		try {
			Nominativo utenteLoggato = null;

			NominativoFiltro f = new NominativoFiltro();
			f.setRuoloContatto(RuoloContattoEnum.UTENTE);
			if (JpaController.callCount(getEmfShared(), Nominativo.class, f) == 0) {
				Nominativo nuovoAdmin = Nominativo.createNew(1, 1);
				nuovoAdmin.setUserName("admin");
				nuovoAdmin.setPassword("admin");
				nuovoAdmin.addRuolo(RuoloContattoEnum.UTENTE);

				new NominativoAPI().salva(getEmfShared(), nuovoAdmin, nuovoAdmin);

				utenteLoggato = nuovoAdmin;
			} else {
				f.setUsername("admin");
				utenteLoggato = JpaController.callFindFirst(getEmfShared(), Nominativo.class, f);
			}

			f = new NominativoFiltro();
			f.setRuoloContatto(RuoloContattoEnum.RIVENDITORE);
			if (JpaController.callCount(getEmfShared(), Nominativo.class, f) == 0) {
				Nominativo nuovoRivenditore = Nominativo.createNew(utenteLoggato, RuoloContattoEnum.RIVENDITORE);
				nuovoRivenditore.setRagioneSociale("PREDEFINITO");
				nuovoRivenditore.setCodice("1");
				Nominativo rivenditorePredefinito = new NominativoAPI().salva(getEmfShared(), utenteLoggato, nuovoRivenditore);
			}

			addInfoMessage("Setup Completato");

		} catch (Exception ex) {
			addErrorMessage("Errore Setup", ex);
		}

		return null;
	}

	public String actionDemo() {
		try {
			
			DemoData demo = new DemoData();
			for (Nominativo c : demo.getClienti()) {
				JpaController.callInsert(getEmfShared(), c);
			}
			
			addInfoMessage("");
		} catch (Exception ex) {
			addErrorMessage("Errore Setup", ex);
		}
		return null;
	}
}
