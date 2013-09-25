package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.api.CrudApi;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.entities.Modulo;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.ModuloFiltro;
import it.attocchi.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;

public class ModuloAPI extends CrudApi<Modulo> {

	public List<Modulo> lista(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Modulo.class, new ModuloFiltro());
	}

	// public void salva(EntityManagerFactory emf, Modulo elemento, List<String>
	// lineeId) throws Exception {
	//
	// Nominativo cliente = JpaController.callFindById(emf, Nominativo.class,
	// elemento.getClienteId());
	// elemento.setClienteDescrizione(cliente.getNomeVisualizzato());
	//
	// elemento.setLinee(ListUtils.toCommaSepared(lineeId));
	//
	// JpaController.callUpdate(emf, elemento);
	//
	// }

	public List<Modulo> listaDaIds(EntityManagerFactory emf, String ids) throws Exception {
		List<Modulo> res = new ArrayList<Modulo>();

		if (StringUtils.isNotBlank(ids)) {
			ModuloFiltro f = new ModuloFiltro();
			f.setIds(ids);
			res = JpaController.callFind(emf, Modulo.class, f);
		}

		return res;
	}

	public void salva(EntityManagerFactory emf, Nominativo currentUser, Linea elemento, List<String> moduliSelezionati) throws Exception {
		
		elemento.setModuli(ListUtils.toCommaSepared(moduliSelezionati));
		elemento.markAsUpdated(currentUser.getId());

		JpaController.callUpdate(emf, elemento);		
	}

}
