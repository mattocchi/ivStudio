package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Postazione;
import it.attocchi.studio74.online.entities.Postazione_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PostazioneFiltro extends JPAEntityFilter<Postazione> {
	private long clienteId;

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Postazione> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Postazione> root) throws Exception {
		if (clienteId > 0) {
			predicateList.add(criteriaBuilder.equal(root.get(Postazione_.clienteId), clienteId));
		}

	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Postazione> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Postazione> root) throws Exception {

	}

}
