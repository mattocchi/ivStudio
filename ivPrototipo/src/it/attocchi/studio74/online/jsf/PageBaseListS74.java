package it.attocchi.studio74.online.jsf;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.jpa2.JpaController;
import it.attocchi.utils.Crono;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Mirco
 * 
 * @param <T>
 * @param <F>
 */
public abstract class PageBaseListS74<T extends Serializable, F extends JPAEntityFilter<T>> extends PageBaseS74 {

	/* LIST */
	protected List<T> elenco;
	protected F filtro;
	protected Class<T> clazz;
	protected long count;
	protected String persistentUnit;

	public List<T> getElenco() {
		return elenco;
	}

	public void setElenco(List<T> elenco) {
		this.elenco = elenco;
	}

	public F getFiltro() {
		return filtro;
	}

	public void setFiltro(F filtro) {
		this.filtro = filtro;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	protected void init() throws Exception {

		// Lo Spostiamo prima di fare la verfica del login altrimenti abbiamo il
		// filtro che e' a null
		inizializeMembers();

		Crono.start("onPreLoadData");
		onPreLoadData();
		Crono.stopAndLogDebug("onPreLoadData", logger);

		Crono.start("loadData");
		loadData();
		Crono.stopAndLogDebug("loadData", logger);

		Crono.start("onPostLoadData");
		onPostLoadData();
		Crono.stopAndLogDebug("onPostLoadData", logger);

		// postInit();
	}

	protected void loadData() throws Exception {

		if (StringUtils.isNotBlank(persistentUnit))
			elenco = JpaController.callFindPU(persistentUnit, clazz, filtro);
		else
			elenco = JpaController.callFind(getEmfShared(), clazz, filtro);

		if (elenco == null || elenco.size() == 0) {
			addErrorMessage("Nessun Dato");
		} else {
			// count = elenco.size();
			if (StringUtils.isNotBlank(persistentUnit))
				count = JpaController.callCountPU(persistentUnit, clazz, filtro);
			else
				count = JpaController.callCount(getEmfShared(), clazz, filtro);

		}
	}

	protected void refreshException() {
		try {
			loadData();
			onPostLoadData();
		} catch (Exception ex) {
			addErrorMessage(ex);
		}
	}

	/**
	 * 
	 * @param filtro
	 * @param clazz
	 */
	// protected abstract void inizializeMembers(F filtro, Class<T> clazz);
	protected abstract void inizializeMembers() throws Exception;

	// abstract postInit();
	protected abstract void onPreLoadData() throws Exception;

	protected abstract void onPostLoadData() throws Exception;

	public String actionReload() {
		refreshException();
		return "";
	}

	public void actionListenerReload(ActionEvent event) {
		refreshException();
	}

	/*
	 * FILTRI AVANZATI ATTIVI
	 */
	private boolean filtri = false;

	public String actionFiltri() {
		filtri = !filtri;
		return null;
	}

	public boolean isFiltri() {
		return filtri;
	}

	public void setFiltri(boolean filtri) {
		this.filtri = filtri;
	}

	public String actionPageNext() {

		this.filtro.setPageNumber(filtro.getPageNumber() + 1);

		return actionReload();
	}

	public String actionPagePrev() {

		if (filtro.getPageNumber() > 0)
			this.filtro.setPageNumber(filtro.getPageNumber() - 1);

		return actionReload();
	}
}
