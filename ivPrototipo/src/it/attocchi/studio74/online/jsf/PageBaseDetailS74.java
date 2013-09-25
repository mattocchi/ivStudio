package it.attocchi.studio74.online.jsf;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.IEntityWithIdLong;
import it.attocchi.utils.Crono;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Mirco
 * 
 * @param <T>
 * @param <F>
 */
public abstract class PageBaseDetailS74<T extends IEntityWithIdLong> extends PageBaseS74 {

	protected T elemento;
	protected long id;
	protected Class<T> clazz;
	protected String persistentUnit;

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	protected void init() throws Exception {

		id = getParamObjectAsLong("id");

		inizializeMembers(); // Spostato da qui prima del login

		Crono.start("onPreLoadData");
		onPreLoadData();
		logger.debug(Crono.stopAndLog("onPreLoadData"));

		Crono.start("loadData");
		loadData();
		logger.debug(Crono.stopAndLog("loadData"));

		Crono.start("onPostLoadData");
		onPostLoadData();
		logger.debug(Crono.stopAndLog("onPostLoadData"));

		// postInit();
	}

	protected void loadData() throws Exception {

		if (id > 0) {
			if (StringUtils.isNotBlank(persistentUnit))
				elemento = JpaController.callFindByIdPU(persistentUnit, clazz, id);
			else
				elemento = JpaController.callFindById(getEmfShared(), clazz, id);

			if (elemento == null) {
				addErrorMessage("Nessun Dato");
			}
		}

	}

	protected void loadDataException() {
		try {
			loadData();
		} catch (Exception ex) {
			addErrorMessage(ex);
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
	// protected abstract void inizializeMembers(Class<T> clazz) throws
	// Exception;
	protected abstract void inizializeMembers() throws Exception;

	// abstract postInit();
	protected abstract void onPreLoadData() throws Exception;

	protected abstract void onPostLoadData() throws Exception;

	// protected String actionSave() {
	// try {
	// JpaController.callUpdate(getEmfShared(), elemento);
	// } catch (Exception ex) {
	// addErrorMessage(ex);
	// }
	// }

}
