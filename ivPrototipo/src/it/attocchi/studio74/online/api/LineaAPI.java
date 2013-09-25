package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.api.CrudApi;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.LineaFiltro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;

public class LineaAPI extends CrudApi {

	public List<Linea> lista(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Linea.class, new LineaFiltro());
	}

	public List<Linea> listaDaIds(EntityManagerFactory emf, String ids) throws Exception {
		List<Linea> res = new ArrayList<Linea>();

		if (StringUtils.isNotBlank(ids)) {
			LineaFiltro f = new LineaFiltro();
			f.setIds(ids);
			res = JpaController.callFind(emf, Linea.class, f);
		}

		return res;
	}
}
