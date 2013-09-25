package it.attocchi.studio74.online.api;

import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.VoceElenco;

import javax.persistence.EntityManagerFactory;

public class VoceElencoAPI extends S74Crud<VoceElenco> {

	@Override
	public void salvaPre(EntityManagerFactory emf, Nominativo utente, VoceElenco elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvaPost(EntityManagerFactory emf, Nominativo utente, VoceElenco elemento, boolean nuovoInserimento) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
