package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.api.exceptions.ivsApiException;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.Nota;
import it.attocchi.studio74.online.filters.NotaFiltro;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;

public class NotaAPI extends S74Crud<Nota> {
	public enum NotaTipoEnum {
		NOTA,
		ASSISTENZA
	}

	public List<Nota> lista(EntityManagerFactory emf, Nominativo currentUser) throws Exception {
		return JpaController.callFind(emf, Nota.class, new NotaFiltro());
	}

	public List<Nota> lista(EntityManagerFactory emf, Nominativo currentUser, Class oggettoClasse, long oggettoId) throws Exception {
		return lista(emf, currentUser, oggettoClasse, oggettoId, null);
	}

	public List<Nota> lista(EntityManagerFactory emf, Nominativo currentUser, Class oggettoClasse, long oggettoId, NotaTipoEnum tipo) throws Exception {
		NotaFiltro filtro = new NotaFiltro();
		filtro.setOggettoClasse(oggettoClasse.getName());
		filtro.setOggettoId(oggettoId);
		if (tipo != null)
			filtro.setTipo(tipo.name());

		List<Nota> res = JpaController.callFind(emf, Nota.class, filtro);

		return res;
	}

	@Override
	public void salvaPre(EntityManagerFactory emf, Nominativo utente, Nota elemento) throws Exception {
		if (elemento == null)
			throw new ivsApiException("Oggetto Nota null");
		
		if (StringUtils.isBlank(elemento.getNota()))
			throw new ivsApiException("Specificare una nota valida.");
	}

	@Override
	public void salvaPost(EntityManagerFactory emf, Nominativo utente, Nota elemento, boolean nuovoInserimento) throws Exception {
		// TODO Auto-generated method stub

	}

}
