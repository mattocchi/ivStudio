package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.api.exceptions.S74ApiException;
import it.attocchi.studio74.online.entities.Licenza;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.filters.LicenzaFiltro;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;

public class LicenzaAPI extends S74Crud<Licenza> {

	public enum LicenzaTipoEnum {
		DESKTOP,
		TERMINAL
	}

	@Override
	public void salvaPre(EntityManagerFactory emf, Nominativo utente, Licenza elemento) throws Exception {

		if (elemento.getClienteId() <= 0)
			throw new S74ApiException("Specificare un Cliente valido.");

		if (elemento.getNumeroPostazioni() <= 0)
			throw new S74ApiException("Specificare un numero di postazioni valido.");

		if (StringUtils.isBlank(elemento.getTipo()))
			throw new S74ApiException("Specificare un Tipo valido.");

	}

	@Override
	public void salvaPost(EntityManagerFactory emf, Nominativo utente, Licenza elemento, boolean nuovoInserimento) throws Exception {

	}

	public List<Licenza> listaByCliente(EntityManagerFactory emf, Nominativo currentUser, long idCliente) throws Exception {
		LicenzaFiltro f = new LicenzaFiltro();
		f.setClienteId(idCliente);
		return JpaController.callFind(emf, Licenza.class, f);
	}

	public Licenza crea(EntityManagerFactory emf, Nominativo utente, long clienteId, int numero, LicenzaTipoEnum tipo) {
		Licenza postazione = new Licenza();
		postazione.setClienteId(clienteId);
		postazione.setNumeroPostazioni(numero);
		postazione.setTipo(tipo.name());

		return postazione;
	}

}
