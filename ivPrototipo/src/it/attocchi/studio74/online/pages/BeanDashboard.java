package it.attocchi.studio74.online.pages;

import static ch.lambdaj.Lambda.*;
import it.attocchi.studio74.online.api.ConsumoAPI;
import it.attocchi.studio74.online.api.ConsumoAPI.ConsumoTipoEnum;
import it.attocchi.studio74.online.api.ContrattoAPI;
import it.attocchi.studio74.online.entities.Consumo;
import it.attocchi.studio74.online.entities.Attivita;
import it.attocchi.studio74.online.jsf.PageBaseS74;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import ch.lambdaj.group.Group;

@ManagedBean
@ViewScoped
public class BeanDashboard extends PageBaseS74 {

	private int contrattiNum;
	private int consumiNum;
	private PieChartModel pieModel;
	private PieChartModel pieModelConsumi;

	List<Attivita> ultimiContratti;
	List<Consumo> ultimeRicariche;

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public int getContrattiNum() {
		return contrattiNum;
	}

	public PieChartModel getPieModelConsumi() {
		return pieModelConsumi;
	}

	public int getConsumiNum() {
		return consumiNum;
	}

	public List<Attivita> getUltimiContratti() {
		return ultimiContratti;
	}

	public void setUltimiContratti(List<Attivita> ultimiContratti) {
		this.ultimiContratti = ultimiContratti;
	}

	public List<Consumo> getUltimeRicariche() {
		return ultimeRicariche;
	}

	public void setUltimeRicariche(List<Consumo> ultimeRicariche) {
		this.ultimeRicariche = ultimeRicariche;
	}

	@Override
	protected void verificaUtentePrivilegiato() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init2() throws Exception {

		ContrattoAPI contrattoAPI = new ContrattoAPI();
		ConsumoAPI consumoAPI = new ConsumoAPI();

		/* CONTRATTI */
		List<Attivita> contratti = contrattoAPI.lista(getEmfShared(), getCurrentUser());
		contrattiNum = contratti.size();
		Group<Attivita> group = group(contratti, by(on(Attivita.class).isScaduto()));
		Group<Attivita> attivi = group.findGroup("false");
		Group<Attivita> scaduti = group.findGroup("true");

		pieModel = new PieChartModel();

		if (attivi != null)
			pieModel.set(attivi.getSize() + " Attivi", attivi.getSize());
		// pieModel.set("Scadenza", 5);
		if (scaduti != null)
			pieModel.set(scaduti.getSize() + " Scaduti", scaduti.getSize());

		/* CONSUMI */
		List<Consumo> consumi = consumoAPI.lista(getEmfShared(), getCurrentUser());
		consumiNum = consumi.size();
		Group<Consumo> groupC = group(consumi, by(on(Consumo.class).getTipo()));
		Group<Consumo> ricariche = groupC.findGroup(ConsumoAPI.ConsumoTipoEnum.FATTURA.name());
		Group<Consumo> usato = groupC.findGroup(ConsumoAPI.ConsumoTipoEnum.PROFORMA.name());

		pieModelConsumi = new PieChartModel();

		if (ricariche != null)
			pieModelConsumi.set(ricariche.getSize() + " Ricarica", ricariche.getSize());
		if (usato != null)
			pieModelConsumi.set(usato.getSize() + " Consumato", usato.getSize());

		/* ULTIMI */
		ultimiContratti = contrattoAPI.listaRecenti(getEmfShared(), getCurrentUser(), 10);
		ultimeRicariche = consumoAPI.listaRecenti(getEmfShared(), getCurrentUser(), ConsumoTipoEnum.FATTURA, 10);

	}

}
