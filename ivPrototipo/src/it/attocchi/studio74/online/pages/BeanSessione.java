package it.attocchi.studio74.online.pages;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jsf2.converter.SelectItemConverter;
import it.attocchi.studio74.online.api.LineaAPI;
import it.attocchi.studio74.online.api.NominativoAPI;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.jsf.PageBaseS74;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class BeanSessione extends PageBaseS74 {

	private List<SelectItem> clienti = new ArrayList<SelectItem>();;
	private List<SelectItem> linee = new ArrayList<SelectItem>();
	private List<SelectItem> licenzaPostazioneTipo = new ArrayList<SelectItem>();
	private List<SelectItem> contrattoVersione = new ArrayList<SelectItem>();
	private List<SelectItem> notaTipo = new ArrayList<SelectItem>();

	public List<SelectItem> getClienti() {
		return clienti;
	}

	public List<SelectItem> getLinee() {
		return linee;
	}

	public List<SelectItem> getLicenzaPostazioneTipo() {
		return licenzaPostazioneTipo;
	}

	public List<SelectItem> getContrattoVersione() {
		return contrattoVersione;
	}

	public List<SelectItem> getNotaTipo() {
		return notaTipo;
	}

	@Override
	protected void init2() throws Exception {
		List<Nominativo> nominativi = new NominativoAPI().listaContatti(getEmfShared(), getCurrentUser());
		clienti = SelectItemConverter.convert(nominativi);

		List<Linea> listaLinee = new LineaAPI().lista(getEmfShared(), getCurrentUser());
		linee = SelectItemConverter.convert(listaLinee);

		licenzaPostazioneTipo.add(new SelectItem("Desktop", "Desktop"));
		// licenzaPostazioneTipo.add(new SelectItem("Server", "Server"));
		licenzaPostazioneTipo.add(new SelectItem("Terminal", "Terminal"));

		contrattoVersione.add(new SelectItem("Contratto Consumo Rev.0", "Contratto Consumo Rev.0"));
		contrattoVersione.add(new SelectItem("Contratto Rev.5", "Contratto Rev.5"));
		contrattoVersione.add(new SelectItem("Contratto Rev.3", "Contratto Rev.3"));
		contrattoVersione.add(new SelectItem("Contratto Rev.2", "Contratto Rev.2"));
		contrattoVersione.add(new SelectItem("Contratto Rev.1", "Contratto Rev.1"));

		notaTipo.add(new SelectItem("NOTA", "Nota"));
		notaTipo.add(new SelectItem("TELEFONATA", "Telefonata"));
		notaTipo.add(new SelectItem("EMAIL", "Email"));
	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	public Nominativo cliente(long idCliente) {
		Nominativo res = null;
		try {
			res = JpaController.callFindById(getEmfShared(), Nominativo.class, idCliente);
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return res;
	}

	public Nominativo utente(long idUtente) {
		Nominativo res = null;
		try {
			res = JpaController.callFindById(getEmfShared(), Nominativo.class, idUtente);
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
		return res;
	}

}
