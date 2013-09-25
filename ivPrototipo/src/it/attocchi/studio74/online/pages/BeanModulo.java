package it.attocchi.studio74.online.pages;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.entities.Modulo;
import it.attocchi.studio74.online.filters.ModuloFiltro;
import it.attocchi.studio74.online.jsf.PageBaseDetailS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

@ManagedBean
@ViewScoped
public class BeanModulo extends PageBaseDetailS74<Modulo> {

	private static final String NUOVO_MODULO = "Nuovo Modulo";

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Modulo.class;

		this.elemento = new Modulo();
		elemento.setNome(NUOVO_MODULO);
		elemento.setValore(1);
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {

	}

	@Override
	protected void preInit() throws PageAuthException {
		// TODO Auto-generated method stub

	}

	public String actionSalva() {

		try {

			if (StringUtils.isBlank(elemento.getNome()) || elemento.getNome().equals(NUOVO_MODULO)) {
				addWarnMessage("Specificare un Nome Valido");
				return null;
			}

			ModuloFiltro f = new ModuloFiltro();
			f.setNome(elemento.getNome());

			Modulo m = JpaController.callFindFirst(getEmfShared(), Modulo.class, f);
			if (m != null) {
				addWarnMessage("Esiste gia' un Modulo con questo nome.");
				return null;
			}

			JpaController.callUpdate(getEmfShared(), elemento);
			addInfoMessage("Modifiche Salvate.");
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return null;

	}

	@Override
	protected void verificaUtentePrivilegiato() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init2() throws Exception {
		// TODO Auto-generated method stub

	}

}
