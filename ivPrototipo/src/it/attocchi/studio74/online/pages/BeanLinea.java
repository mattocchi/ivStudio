package it.attocchi.studio74.online.pages;

import it.attocchi.jsf2.converter.SelectItemConverter;
import it.attocchi.jsf2.exceptions.PageAuthException;
import it.attocchi.studio74.online.api.ModuloAPI;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.jsf.PageBaseDetailS74;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;

@ManagedBean
@ViewScoped
public class BeanLinea extends PageBaseDetailS74<Linea> {

	private static final String NUOVA_LINEA = "Nuova Linea";
	// private DualListModel<String> moduli;
	//
	// public DualListModel<String> getModuli() {
	// return moduli;
	// }
	//
	// public void setModuli(DualListModel<String> moduli) {
	// this.moduli = moduli;
	// }

	private List<SelectItem> moduli = new ArrayList<SelectItem>();
	private List<String> moduliSelezionati = new ArrayList<String>();

	public List<SelectItem> getModuli() {
		return moduli;
	}

	public void setModuli(List<SelectItem> moduli) {
		this.moduli = moduli;
	}

	public List<String> getModuliSelezionati() {
		return moduliSelezionati;
	}

	public void setModuliSelezionati(List<String> moduliSelezionati) {
		this.moduliSelezionati = moduliSelezionati;
	}

	@Override
	protected void inizializeMembers() throws Exception {
		this.clazz = Linea.class;

		this.elemento = new Linea();
		elemento.setNome(NUOVA_LINEA);
	}

	@Override
	protected void onPreLoadData() throws Exception {

	}

	@Override
	protected void onPostLoadData() throws Exception {
		// //
		// List<String> source = new ArrayList<String>();
		// List<String> target = new ArrayList<String>();
		//
		// for (Modulo modulo : JpaController.callFind(getEmfShared(),
		// Modulo.class, new ModuloFiltro())) {
		// source.add(modulo.getNome());
		// }
		//
		// /* Se ci sono Moduli Selezionati li associo */
		// if (StringUtils.isNotBlank(elemento.getModuli())) {
		// ModuloFiltro filtro = new ModuloFiltro();
		// filtro.setIds(elemento.getModuli());
		// for (Modulo modulo : JpaController.callFind(getEmfShared(),
		// Modulo.class, filtro)) {
		// target.add(modulo.getNome());
		// }
		// }

		// moduli = new DualListModel<String>(source, target);
		moduli = SelectItemConverter.convert(new ModuloAPI().lista(getEmfShared(), getCurrentUser()));
		moduliSelezionati = ListUtils.fromCommaSepared(elemento.getModuli());
	}

	@Override
	protected void preInit() throws PageAuthException {
		// TODO Auto-generated method stub

	}

	public String actionSalva() {

		try {

			if (StringUtils.isBlank(elemento.getNome()) || elemento.getNome().equals(NUOVA_LINEA)) {
				addWarnMessage("Specificare un Nome Valido");
				return null;
			}

			// /* Associazione dei Moduli Selezionati */
			// List<Long> moduliSelezionati = new ArrayList<Long>();
			// for (String nomeModulo : moduli.getTarget()) {
			//
			// ModuloFiltro f = new ModuloFiltro();
			// f.setNome(nomeModulo);
			//
			// Modulo m = JpaController.callFindFirst(getEmfShared(),
			// Modulo.class, f);
			// if (m != null)
			// moduliSelezionati.add(m.getId());
			// }

			new ModuloAPI().salva(getEmfShared(), getCurrentUser(), elemento, moduliSelezionati);

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
