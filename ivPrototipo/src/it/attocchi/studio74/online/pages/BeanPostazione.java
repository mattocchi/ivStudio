package it.attocchi.studio74.online.pages;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.api.PostazioneAPI;
import it.attocchi.studio74.online.entities.Postazione;
import it.attocchi.studio74.online.filters.PostazioneFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanPostazione extends PageBaseListS74<Postazione, PostazioneFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Postazione.class;
		this.filtro = new PostazioneFiltro();

		// this.elemento = new Postazione();
	}

	public String actionAggiungi() {
		try {
			// new PostazioneAPI().salva(getEmfShared(), getCurrentUser(),
			// elemento);

			loadData();
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return null;
	}

	@Override
	protected void onPreLoadData() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onPostLoadData() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void verificaUtentePrivilegiato() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init2() throws Exception {
		// TODO Auto-generated method stub

	}

	public void cambiaAutorizzazione(long idPostazione) {
		try {
			if (idPostazione > 0) {
				Postazione postazione = JpaController.callFindById(getEmfShared(), Postazione.class, idPostazione);
				if (postazione != null) {
					boolean actionAutorizzazione = !postazione.isAutorizzata();
					postazione.setAutorizzata(!postazione.isAutorizzata());
					new PostazioneAPI().salva(getEmfShared(), getCurrentUser(), postazione);
					if (actionAutorizzazione)
						addInfoMessage(String.format("Postazione %s AUTORIZZATA.", postazione.getNomePc()));
					else
						addWarnMessage(String.format("Postazione %s DISATTIVATA.", postazione.getNomePc()));

				}
			}
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
	}
}
