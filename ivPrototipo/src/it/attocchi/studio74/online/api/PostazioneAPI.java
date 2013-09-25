package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.Postazione;
import it.attocchi.studio74.online.filters.PostazioneFiltro;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public class PostazioneAPI extends S74Crud<Postazione> {

	@Override
	public void salvaPre(EntityManagerFactory emf, Nominativo utente, Postazione elemento) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void salvaPost(EntityManagerFactory emf, Nominativo utente, Postazione elemento, boolean nuovoInserimento) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Postazione> listaByCliente(EntityManagerFactory emf, Nominativo currentUser, long clienteId) throws Exception {
		PostazioneFiltro filtro = new PostazioneFiltro();
		filtro.setClienteId(clienteId);

		List<Postazione> res = JpaController.callFind(emf, Postazione.class, filtro);

		return res;
	}
}
