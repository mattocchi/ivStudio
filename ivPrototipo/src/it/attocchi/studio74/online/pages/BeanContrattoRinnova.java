package it.attocchi.studio74.online.pages;

import it.attocchi.jsf2.converter.SelectItemConverter;
import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.api.ContrattoAPI;
import it.attocchi.studio74.online.api.LineaAPI;
import it.attocchi.studio74.online.entities.Contratto;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.jsf.PageBaseDetailS74;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class BeanContrattoRinnova extends PageBaseDetailS74<Contratto> {

	private List<SelectItem> clienti = new ArrayList<SelectItem>();;
	private List<SelectItem> linee = new ArrayList<SelectItem>();
	private long clienteSelezionato;
	private List<String> lineeSelezionate = new ArrayList<String>();

	public List<SelectItem> getClienti() {
		return clienti;
	}

	public void setClienti(List<SelectItem> clienti) {
		this.clienti = clienti;
	}

	public List<SelectItem> getLinee() {
		return linee;
	}

	public void setLinee(List<SelectItem> linee) {
		this.linee = linee;
	}

	public List<String> getLineeSelezionate() {
		return lineeSelezionate;
	}

	public void setLineeSelezionate(List<String> lineeSelezionate) {
		this.lineeSelezionate = lineeSelezionate;
	}

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Contratto.class;

		this.elemento = new ContrattoAPI().nuovo(getCurrentUser(), 1);
	}

	@Override
	protected void onPreLoadData() throws Exception {

		// List<Nominativo> nominativi = new
		// NominativoAPI().listaContatti(getEmfShared(), getCurrentUser());
		// clienti = SelectItemConverter.convert(nominativi);

		List<Linea> listaLinee = new LineaAPI().lista(getEmfShared(), getCurrentUser());
		linee = SelectItemConverter.convert(listaLinee);

		long idRinnovo = getParamObjectAsLong("idRinnovo");
		if (idRinnovo > 0) {
			elemento = new ContrattoAPI().rinnovoPrepara(getEmfShared(), getCurrentUser(), idRinnovo);
		} else {
			addErrorMessage("Impossibile trovare il contratto da rinnovare.");
		}

	}

	@Override
	protected void onPostLoadData() throws Exception {

		// if (id > 0) {
		if (elemento != null) {
			lineeSelezionate = ListUtils.fromCommaSepared(elemento.getLinee());
		}
	}

	@Override
	protected void preInit() throws PageAuthException {
		// TODO Auto-generated method stub

	}

	public String actionSalva() {

		try {

			new ContrattoAPI().rinnovoSalva(getEmfShared(), getCurrentUser(), elemento, lineeSelezionate);

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
