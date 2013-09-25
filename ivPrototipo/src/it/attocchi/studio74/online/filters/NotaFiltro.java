package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Nota;
import it.attocchi.studio74.online.entities.Nota_;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class NotaFiltro extends JPAEntityFilter<Nota> {

	private String oggettoClasse;
	private long oggettoId;
	private String tipo;

	public String getOggettoClasse() {
		return oggettoClasse;
	}

	public void setOggettoClasse(String oggetto) {
		this.oggettoClasse = oggetto;
	}

	public long getOggettoId() {
		return oggettoId;
	}

	public void setOggettoId(long oggettoId) {
		this.oggettoId = oggettoId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Nota> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Nota> root) throws Exception {
		if (oggettoId > 0) {
			Predicate p1 = criteriaBuilder.equal(root.get(Nota_.oggettoId), oggettoId);
			predicateList.add(p1);
		}

		if (StringUtils.isNotBlank(oggettoClasse)) {
			Predicate p1 = criteriaBuilder.equal(root.get(Nota_.oggetto), oggettoClasse);
			predicateList.add(p1);
		}

		if (StringUtils.isNotBlank(tipo)) {
			Predicate p1 = criteriaBuilder.equal(root.get(Nota_.tipo), tipo);
			predicateList.add(p1);
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Nota> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Nota> root) throws Exception {

	}
}