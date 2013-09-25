package it.attocchi.studio74.online.pages;

import static ch.lambdaj.Lambda.*;
import it.attocchi.studio74.online.api.LicenzaAPI;
import it.attocchi.studio74.online.entities.Licenza;
import it.attocchi.studio74.online.filters.LicenzaFiltro;
import it.attocchi.studio74.online.jsf.PageBaseMasterDetailS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanLicenza extends PageBaseMasterDetailS74<Licenza, LicenzaFiltro> {

	private int licenzeTot;

	public int getLicenzeTot() {
		return licenzeTot;
	}

	public void setLicenzeTot(int licenzeTot) {
		this.licenzeTot = licenzeTot;
	}

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Licenza.class;
		this.filtro = new LicenzaFiltro();

		this.elemento = new Licenza();
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {
		licenzeTot = sum(elenco, on(Licenza.class).getNumeroPostazioni());
	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	@Override
	protected void init2() throws Exception {

	}

	public String actionAggiungi() {
		try {
			new LicenzaAPI().salva(getEmfShared(), getCurrentUser(), elemento);

			loadData();
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return null;
	}

}
