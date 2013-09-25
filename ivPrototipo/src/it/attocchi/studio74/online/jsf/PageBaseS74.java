package it.attocchi.studio74.online.jsf;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jsf2.PageBaseAuth;
import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.api.NominativoAPI.GruppoUtenteEnum;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.utils.ListUtils;

import java.util.List;

public abstract class PageBaseS74 extends PageBaseAuth {

	// public Configurazione getConfigurazione() {
	// return Configurazione.getCurrent(getEmfShared());
	// }

	public Nominativo currentUser;
	public List<GruppoUtenteEnum> currentGroups;

	protected boolean utentePrivilegiato;

	public Nominativo getCurrentUser() {
		boolean updateLogin = false;

		/*
		 * Gestisco il Primo Login ed eventuali cambi di Login nella stessa
		 * sessione
		 */
		if (currentUser == null) {
			if (isUtenteLoggato()) {
				updateLogin = true;
			}
		} else {
			if (currentUser.getId() != getIdUtenteLoggato()) {
				updateLogin = true;
			}
		}

		if (updateLogin) {
			try {
				currentUser = JpaController.callFindById(getEmfShared(), Nominativo.class, getIdUtenteLoggato());
				/* Reset dei Gruppi */
				currentGroups = null;
			} catch (Exception ex) {
				logger.error(ex);
			}
		}
		return currentUser;
	}

	public void setCurrentUser(Nominativo currentUser) {
		this.currentUser = currentUser;
	}

	public List<GruppoUtenteEnum> getCurrentRoles() {
		if (currentGroups == null && isUtenteLoggato()) {
			try {
				// currentGroups = new
				// RuoloContattoApi().gruppiUtente(getEmfShared(),
				// getCurrentUser());

				currentGroups = new NominativoAPI().gruppiUtente(getCurrentUser());
			} catch (Exception ex) {
				logger.error(ex);
			}
		}
		return currentGroups;
	}

	public boolean isInRole(GruppoUtenteEnum aRole) {
		boolean res = false;
		if (ListUtils.isNotEmpty(getCurrentRoles())) {
			for (GruppoUtenteEnum e : getCurrentRoles()) {
				if (e.equals(aRole)) {
					res = true;
					break;
				}
			}
		}
		return res;
	}

	public boolean isAdmin() {
		return isInRole(GruppoUtenteEnum.ADMIN);
	}

	// protected boolean isCurrentUserInGroup(String gruppo) {
	// return StringFunc.contains(getCurrentGroups().toString(), gruppo);
	// }

	public void setCurrentGroups(List<GruppoUtenteEnum> currentGroups) {
		this.currentGroups = currentGroups;
	}

	public boolean isUtentePrivilegiato() {
		return utentePrivilegiato;
	}

	public void setUtentePrivilegiato(boolean utentePrivilegiato) {
		this.utentePrivilegiato = utentePrivilegiato;
	}

	protected abstract void verificaUtentePrivilegiato();

	@Override
	protected void init() throws Exception {

		verificaUtentePrivilegiato();

		init2();
	}

	protected abstract void init2() throws Exception;
}
