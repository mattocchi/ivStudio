package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.api.NominativoAPI.RuoloContattoEnum;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.NominativoFiltro;
import it.attocchi.studio74.online.jsf.PageBaseListS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanClienti extends PageBaseListS74<Nominativo, NominativoFiltro> {

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Nominativo.class;
		this.filtro = new NominativoFiltro();

		filtro.setPageNumber(0);
		filtro.setLimit(50);
		filtro.setRuoloContatto(RuoloContattoEnum.CONTATTO);
	}

	@Override
	protected void onPreLoadData() throws Exception {

		// DemoData demo = new DemoData();
		// demo.salva(getEmfShared());

	}

	@Override
	protected void onPostLoadData() throws Exception {

		// clienti = demo.getClienti();
		// List<Accesso> accessi = demo.getAccessi();

		// actionCerca();

		// addInfoMessage("getDemoData");
		// addErrorMessage("getDemoData");

		// elenco = risultati;
	}

	// private List<Cliente> clienti;
	// // private List<Accesso> accessi;
	// //
	// // private String semeRicerca;
	// private List<Cliente> risultati;

	//
	// public List<Cliente> getClienti() {
	// return clienti;
	// }
	//
	// public void setClienti(List<Cliente> clienti) {
	// this.clienti = clienti;
	// }
	//
	// public List<Accesso> getAccessi() {
	// return accessi;
	// }
	//
	// public void setAccessi(List<Accesso> accessi) {
	// this.accessi = accessi;
	// }
	//
	// public String getSemeRicerca() {
	// return semeRicerca;
	// }
	//
	// public void setSemeRicerca(String semeRicerca) {
	// this.semeRicerca = semeRicerca;
	// }

	// public List<Cliente> getRisultati() {
	// return risultati;
	// }
	//
	// public void setRisultati(List<Cliente> risultati) {
	// this.risultati = risultati;
	// }

	//
	// @Override
	// protected void init() throws Exception {
	// DemoData demo = new DemoData();
	//
	// clienti = demo.getClienti();
	// accessi = demo.getAccessi();
	//
	// actionCerca();
	//
	// // addInfoMessage("getDemoData");
	// // addErrorMessage("getDemoData");
	// }
	//
	public String actionCerca() {

		// if (risultati == null)
		// risultati = new ArrayList<Cliente>();
		//
		// risultati.clear();
		// if (this.filtro.getSemeRicerca() != null)
		// risultati =
		// ch.lambdaj.Lambda.filter(ch.lambdaj.Lambda.having(ch.lambdaj.Lambda.on(Cliente.class).getPartitaIva(),
		// org.hamcrest.Matchers.containsString(this.filtro.getSemeRicerca())),
		// elenco);
		// else
		// risultati.addAll(elenco);
		//
		// /*
		// * addInfoMessage("Test"); addErrorMessage("Test ERRORE");
		// */
		// if (risultati.size() == 0) {
		// addWarnMessage("Nessun Dato");
		// }
		//
		// return null;

		refreshException();

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
