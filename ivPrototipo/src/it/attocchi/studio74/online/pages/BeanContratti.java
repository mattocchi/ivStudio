package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.entities.Attivita;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.AttivitaFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanContratti extends PageBaseListS74<Attivita, AttivitaFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Attivita.class;
		this.filtro = new AttivitaFiltro();

		filtro.setPageNumber(0);
		filtro.setLimit(50);
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {

	}

	public String actionCerca() {
		refreshException();
		return null;
	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	@Override
	protected void init2() throws Exception {

	}

	public List<Nominativo> elencoLinee(String ids) {
		List<Nominativo> res = new ArrayList<Nominativo>();
		try {
			// res = new LineaAPI().listaDaIds(getEmfShared(), ids);
			res = new NominativoAPI().listaDaIds(getEmfShared(), ids);
		} catch (Exception ex) {
			addWarnMessage(ex.getMessage());
		}
		return res;
	}
}
