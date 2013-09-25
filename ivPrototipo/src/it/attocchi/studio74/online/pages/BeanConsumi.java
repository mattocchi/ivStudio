package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.entities.Consumo;
import it.attocchi.studio74.online.filters.ConsumoFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanConsumi extends PageBaseListS74<Consumo, ConsumoFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Consumo.class;
		this.filtro = new ConsumoFiltro();

		filtro.setPageNumber(0);
		filtro.setLimit(50);
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {

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
