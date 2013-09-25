package it.attocchi.studio74.online.pages;

import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.api.NominativoAPI.RuoloContattoEnum;
import it.attocchi.studio74.online.api.NotaAPI;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.Nota;
import it.attocchi.studio74.online.jsf.PageBaseDetailS74;
import it.attocchi.studio74.online.stat.StatoCliente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanCliente extends PageBaseDetailS74<Nominativo> {

	StatoCliente statoCliente;
	Nota nuovaNota;

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Nominativo.class;

		this.elemento = Nominativo.createNew(getCurrentUser(), RuoloContattoEnum.CONTATTO);
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {

		if (id > 0) {

			statoCliente = new StatoCliente();
			statoCliente.calcola(getEmfShared(), getCurrentUser(), id);

			initNuovaNota();

		}

	}

	@Override
	protected void preInit() throws PageAuthException {
		// TODO Auto-generated method stub

	}

	public String actionSalva() {

		try {

			new NominativoAPI().salva(getEmfShared(), getCurrentUser(), elemento);

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

	public Nota getNuovaNota() {
		return nuovaNota;
	}

	public StatoCliente getStatoCliente() {
		return statoCliente;
	}

	public void setStatoCliente(StatoCliente statoCliente) {
		this.statoCliente = statoCliente;
	}

	public void setNuovaNota(Nota nuovaNota) {
		this.nuovaNota = nuovaNota;
	}

	private void initNuovaNota() {
		nuovaNota = new Nota();
		nuovaNota.setOggetto(Nominativo.class.getName());
		nuovaNota.setOggettoId(id);
	}

	public String actionAggiungiNota() {
		try {
			new NotaAPI().salva(getEmfShared(), getCurrentUser(), nuovaNota);

			refreshException();

			initNuovaNota();

		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return null;
	}
}
