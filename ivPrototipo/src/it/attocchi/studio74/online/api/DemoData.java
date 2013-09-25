package it.attocchi.studio74.online.api;

import it.attocchi.jpa2.JpaController;
import it.attocchi.studio74.online.entities.Nominativo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.RandomStringUtils;

public class DemoData {

	List<Nominativo> clienti;

	public List<Nominativo> getClienti() {
		return clienti;
	}

	public void setClienti(List<Nominativo> clienti) {
		this.clienti = clienti;
	}

	public DemoData() {
		super();

		clienti = new ArrayList<Nominativo>();

		for (int cliente = 0; cliente < 10000; cliente++) {
			Nominativo c = demoCliente(cliente);
			clienti.add(c);

//			for (int accesso = 0; accesso < 1000; accesso++) {
//				accessi.add(demoAccesso(accesso, c.getPartitaIva()));
//			}
		}
	}

	public Nominativo demoCliente(int numero) {
		// Cliente nuovo = new Cliente();
		Nominativo nuovo = Nominativo.createNew(1, 1);
		// nuovo.setId(numero);
		nuovo.setPartitaIva(RandomStringUtils.random(13, false, true)); // StringUtils.right(new
																		// String("0000000000000"
																		// +
																		// numero),
																		// 13));
		nuovo.setRagioneSociale("Ragione Sociale " + RandomStringUtils.random(20, true, true)); // "Ragione Sociale "
																								// +
																								// numero);

		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -30);

		Calendar c2 = Calendar.getInstance();

		Calendar c3 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -10);

		// if (numero % 3 == 0) {
		// nuovo.setStato("Attivo");
		// nuovo.setUltimoAccesso(c1.getTime());
		// nuovo.setLicenza("1 Postazione");
		// } else if (numero % 2 == 0) {
		// nuovo.setStato("Riserva");
		// nuovo.setUltimoAccesso(c2.getTime());
		// // nuovo.setLicenza("40 Utenti Terminal");
		// nuovo.setLicenza("Consumo (40/100)");
		// } else {
		// nuovo.setStato("Scaduto");
		// nuovo.setUltimoAccesso(c3.getTime());
		// nuovo.setLicenza("5 Postazioni Rete");
		// }

		return nuovo;
	}

//	public Accesso demoAccesso(int numero, String partitaIva) {
//		Accesso nuovo = new Accesso();
//		nuovo.setRivenditore(1);
//		nuovo.setData(new Date());
//
//		if (numero % 2 == 0) {
//			nuovo.setOs("Windows 7");
//
//		} else {
//			nuovo.setOs("Windows XP");
//
//		}
//
//		nuovo.setPartitaIva(partitaIva);
//
//		nuovo.setMacAddress("00-00-00-00-00");
//
//		return nuovo;
//	}

	public void salva(EntityManagerFactory emf) throws Exception {

		if (JpaController.callCount(emf, Nominativo.class, null) == 0)
			for (Nominativo c : clienti) {
				JpaController.callInsert(emf, c);
			}
	}
}
