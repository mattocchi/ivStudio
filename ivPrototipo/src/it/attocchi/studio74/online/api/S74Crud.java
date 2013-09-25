package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.jpa2.entities.AbstractEntityMarksWithIdLong;
import it.attocchi.jpa2.entities.api.CrudApi;
import it.attocchi.studio74.online.entities.Nominativo;

import javax.persistence.EntityManagerFactory;

public abstract class S74Crud<T extends AbstractEntityMarksWithIdLong> extends CrudApi<T> {

	public abstract void salvaPre(EntityManagerFactory emf, Nominativo utente, T elemento) throws Exception;

	public void salva(EntityManagerFactory emf, Nominativo utente, T elemento) throws Exception {

		salvaPre(emf, utente, elemento);

		boolean nuovoInserimento = elemento.getId() <= 0;
		if (nuovoInserimento) {
			elemento.markAsCreated(utente.getId());
			elemento.markAsUpdated(utente.getId());
			JpaController.callInsert(emf, elemento);
		} else {
			elemento.markAsUpdated(utente.getId());
			JpaController.callUpdate(emf, elemento);
		}

		salvaPost(emf, utente, elemento, nuovoInserimento);
	}

	public abstract void salvaPost(EntityManagerFactory emf, Nominativo utente, T elemento, boolean nuovoInserimento) throws Exception;
}
