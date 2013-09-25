package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.api.LineaAPI;
import it.attocchi.studio74.online.entities.Contratto;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.filters.ContrattoFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanContratti extends PageBaseListS74<Contratto, ContrattoFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Contratto.class;
		this.filtro = new ContrattoFiltro();

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

	public List<Linea> elencoLinee(String ids) {
		List<Linea> res = new ArrayList<Linea>();
		try {
			res = new LineaAPI().listaDaIds(getEmfShared(), ids);
		} catch (Exception ex) {
			addWarnMessage(ex.getMessage());
		}
		return res;
	}
}