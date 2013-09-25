package it.attocchi.studio74.online.pages;

import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.api.ContrattoAPI;
import it.attocchi.studio74.online.entities.Contratto;
import it.attocchi.studio74.online.jsf.PageBaseDetailS74;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanContratto extends PageBaseDetailS74<Contratto> {

	private long clienteSelezionato;
	private List<String> lineeSelezionate = new ArrayList<String>();

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
		
	}

	@Override
	protected void onPostLoadData() throws Exception {

		if (id > 0) {
			lineeSelezionate = ListUtils.fromCommaSepared(elemento.getLinee());
		}
	}

	@Override
	protected void preInit() throws PageAuthException {

	}

	public String actionSalva() {

		try {

			new ContrattoAPI().salva(getEmfShared(), getCurrentUser(), elemento, lineeSelezionate);

			addInfoMessage("Modifiche Salvate.");

		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return null;

	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	@Override
	protected void init2() throws Exception {

	}

}
