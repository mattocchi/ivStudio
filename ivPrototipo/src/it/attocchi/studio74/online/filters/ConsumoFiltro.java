package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.api.ConsumoAPI.ConsumoTipoEnum;
import it.attocchi.studio74.online.entities.Consumo;
import it.attocchi.studio74.online.entities.Consumo_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ConsumoFiltro extends JPAEntityFilter<Consumo> {

	private long clienteId;

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	private ConsumoTipoEnum tipo;

	public ConsumoTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(ConsumoTipoEnum tipo) {
		this.tipo = tipo;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Consumo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Consumo> root) throws Exception {

		if (clienteId > 0) {
			predicateList.add(criteriaBuilder.equal(root.get(Consumo_.clienteId), clienteId));
		}

		if (tipo != null) {
			predicateList.add(criteriaBuilder.equal(root.get(Consumo_.tipo), tipo.name()));
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Consumo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Consumo> root) throws Exception {
		Order a = criteriaBuilder.desc(root.get(Consumo_.data));
		orderList.add(a);
	}

}
