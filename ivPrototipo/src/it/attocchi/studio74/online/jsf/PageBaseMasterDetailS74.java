package it.attocchi.studio74.online.jsf;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.jpa2.JpaController;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Mirco
 * 
 * @param <T>
 * @param <F>
 */
// public abstract class PageBaseMasterDetailS74<T extends Serializable, F
// extends JPAEntityFilter<T>> extends PageBaseS74 {
public abstract class PageBaseMasterDetailS74<T extends Serializable, F extends JPAEntityFilter<T>> extends PageBaseListS74<T, F> {

	// /* LIST */
	// protected List<T> elenco;
	// protected F filtro;
	// protected Class<T> clazz;
	// protected long count;
	// protected String persistentUnit;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* DETAIL */
	protected T elemento;
	protected long id;

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	protected void onPreLoadData() throws Exception {
		id = getParamObjectAsLong("id");
	}

	@Override
	protected void onPostLoadData() throws Exception {
		/* DETAIL */
		if (id > 0) {
			if (StringUtils.isNotBlank(persistentUnit))
				elemento = JpaController.callFindByIdPU(persistentUnit, clazz, id);
			else
				elemento = JpaController.callFindById(getEmfShared(), clazz, id);

			// if (elemento == null) {
			// addErrorMessage("Nessun Dato");
			// }
		}
	}

}
