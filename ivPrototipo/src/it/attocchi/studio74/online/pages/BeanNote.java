package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.entities.Nota;
import it.attocchi.studio74.online.filters.NotaFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanNote extends PageBaseListS74<Nota, NotaFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Nota.class;
		this.filtro = new NotaFiltro();

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
}
