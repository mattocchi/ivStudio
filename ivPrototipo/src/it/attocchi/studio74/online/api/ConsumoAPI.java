package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.api.CrudApi;
import it.attocchi.studio74.online.entities.Consumo;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.ConsumoFiltro;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public class ConsumoAPI extends CrudApi<Consumo> {

	public enum ConsumoTipoEnum {
		RICARICA,
		CONSUMO
	}

	public List<Consumo> lista(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Consumo.class, new ConsumoFiltro());
	}

	public List<Consumo> lista(EntityManagerFactory emf, Nominativo currentUser, ConsumoTipoEnum tipo) throws Exception {
		ConsumoFiltro filtro = new ConsumoFiltro();
		filtro.setTipo(tipo);
		return JpaController.callFind(emf, Consumo.class, filtro);
	}

	public void salva(EntityManagerFactory emf, Nominativo currentUser, Consumo elemento) throws Exception {

		elemento.setClienteDescrizione(new NominativoAPI().cerca(emf, elemento.getClienteId()).getNomeVisualizzato());

		JpaController.callUpdate(emf, elemento);

	}

	public List<Consumo> listaByCliente(EntityManagerFactory emf, Nominativo currentUser, long idCliente) throws Exception {
		ConsumoFiltro f = new ConsumoFiltro();
		f.setClienteId(idCliente);
		return JpaController.callFind(emf, Consumo.class, f);
	}

	public List<Consumo> listaRecenti(EntityManagerFactory emf, Nominativo currentUser, ConsumoTipoEnum ricarica, int limite) throws Exception {
		ConsumoFiltro filtro = new ConsumoFiltro();
		filtro.setLimit(limite);
		return JpaController.callFind(emf, Consumo.class, filtro);
	}
}
