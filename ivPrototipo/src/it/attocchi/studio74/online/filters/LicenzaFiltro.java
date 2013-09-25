package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Licenza;
import it.attocchi.studio74.online.entities.Licenza_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class LicenzaFiltro extends JPAEntityFilter<Licenza> {
	private long clienteId;
	private String tipo;

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Licenza> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Licenza> root) throws Exception {
		if (clienteId > 0) {
			predicateList.add(criteriaBuilder.equal(root.get(Licenza_.clienteId), clienteId));
		}

		if (StringUtils.isNotBlank(tipo)) {
			predicateList.add(criteriaBuilder.equal(root.get(Licenza_.tipo), tipo));
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Licenza> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Licenza> root) throws Exception {
		// TODO Auto-generated method stub

	}

}
