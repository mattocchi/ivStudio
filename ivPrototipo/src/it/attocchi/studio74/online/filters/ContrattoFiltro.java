package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Contratto;
import it.attocchi.studio74.online.entities.Contratto_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class ContrattoFiltro extends JPAEntityFilter<Contratto> {

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
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Contratto> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Contratto> root) throws Exception {

		if (StringUtils.isNotBlank(semeRicerca)) {

			// Predicate p1 = criteriaBuilder.like(root.get(Contratto_.),
			// getSemeRicercaForLike());
			//
			// Predicate or = criteriaBuilder.or(p1);
			// predicateList.add(or);
		}

		if (!includiObsoleti) {

			predicateList.add(criteriaBuilder.equal(root.get(Contratto_.obsoleto), false));

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
			// predicateList.add(root.get(Contratto_.id).in(ids));

		}

		if (soloRinnovi) {
			predicateList.add(root.get(Contratto_.contrattoPadreId).isNotNull());
			predicateList.add(criteriaBuilder.greaterThan(root.get(Contratto_.contrattoPadreId), 0l));
		}

		if (clienteId > 0) {
			predicateList.add(criteriaBuilder.equal(root.get(Contratto_.clienteId), clienteId));
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Contratto> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Contratto> root) throws Exception {

		Order a = criteriaBuilder.asc(root.get(Contratto_.clienteDescrizione));
		Order b = criteriaBuilder.asc(root.get(Contratto_.licenzaNumero));
		Order c = criteriaBuilder.desc(root.get(Contratto_.consumoDataInizio));

		// Order b =
		// criteriaBuilder.desc(root.get(Contratto_.entityMarks).get(EntityMarksUUID_.dataCreazione));
		orderList.add(a);
		orderList.add(b);
		orderList.add(c);
	}
}
