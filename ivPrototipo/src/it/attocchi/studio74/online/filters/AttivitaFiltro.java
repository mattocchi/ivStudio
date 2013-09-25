package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Attivita;
import it.attocchi.studio74.online.entities.Attivita_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class AttivitaFiltro extends JPAEntityFilter<Attivita> {

	private boolean soloRinnovi;
	private boolean includiObsoleti;

	public boolean isIncludiObsoleti() {
		return includiObsoleti;
	}

	public void setIncludiObsoleti(boolean includiObsoleti) {
		this.includiObsoleti = includiObsoleti;
	}

	private long clienteId;

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Attivita> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Attivita> root) throws Exception {

		if (StringUtils.isNotBlank(semeRicerca)) {

			// Predicate p1 = criteriaBuilder.like(root.get(Attivita_.),
			// getSemeRicercaForLike());
			//
			// Predicate or = criteriaBuilder.or(p1);
			// predicateList.add(or);
		}

		if (!includiObsoleti) {

			predicateList.add(criteriaBuilder.equal(root.get(Attivita_.obsoleto), false));

			// LicenzaFiltro filtroRinnovi = new LicenzaFiltro();
			// // filtroRinnovi.setSoloRinnovi(true);
			// List<Licenza> licenze = JpaController.callFind(emf,
			// Licenza.class, filtroRinnovi);
			// /*
			// * Raggruppo per Cliente, Licenza, e prendo quello con data Data
			// * Attivazione piu recente
			// */
			// // Group<Licenza> groupByClienteLicenzaId = group(licenze,
			// // by(on(Licenza.class).getClienteId()),
			// // by(on(Licenza.class).getLicenzaId()));
			// Map<String, Licenza> map = new HashMap<String, Licenza>();
			// for (Licenza licenza : licenze) {
			// String key = licenza.getClienteId() + "-" +
			// licenza.getLicenzaNumero();
			// if (map.containsKey(key)) {
			// if (licenza.getDataFine() == null ||
			// licenza.getDataFine().after(map.get(key).getDataFine())) {
			// map.put(key, licenza);
			// }
			// } else {
			// map.put(key, licenza);
			// }
			// }
			// List<Long> ids = new ArrayList<Long>();
			// ids.addAll(ch.lambdaj.Lambda.project(map.values(), Long.class,
			// ch.lambdaj.Lambda.on(Licenza.class).getId()));
			// /* Filtro solo per Questi */
			// predicateList.add(root.get(Attivita_.id).in(ids));

		}

		if (soloRinnovi) {
			predicateList.add(root.get(Attivita_.contrattoPadreId).isNotNull());
			predicateList.add(criteriaBuilder.greaterThan(root.get(Attivita_.contrattoPadreId), 0l));
		}

		if (clienteId > 0) {
			predicateList.add(criteriaBuilder.equal(root.get(Attivita_.clienteId), clienteId));
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Attivita> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Attivita> root) throws Exception {

		Order a = criteriaBuilder.asc(root.get(Attivita_.clienteDescrizione));
		Order b = criteriaBuilder.asc(root.get(Attivita_.licenzaNumero));
		Order c = criteriaBuilder.desc(root.get(Attivita_.consumoDataInizio));

		// Order b =
		// criteriaBuilder.desc(root.get(Attivita_.entityMarks).get(EntityMarksUUID_.dataCreazione));
		orderList.add(a);
		orderList.add(b);
		orderList.add(c);
	}
}
