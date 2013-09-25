package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Linea;
import it.attocchi.studio74.online.entities.Linea_;
import it.attocchi.utils.ListUtils;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class LineaFiltro extends JPAEntityFilter<Linea> {

	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Linea> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Linea> root) throws Exception {
		if (StringUtils.isNotBlank(semeRicerca)) {

			Predicate p1 = criteriaBuilder.like(root.get(Linea_.nome), getSemeRicercaForLike());
			Predicate p2 = criteriaBuilder.like(root.get(Linea_.codice), getSemeRicercaForLike());

			Predicate or = criteriaBuilder.or(p1, p2);
			predicateList.add(or);
		}

		if (StringUtils.isNotBlank(ids)) {
			List<Long> listaId = ListUtils.fromCommaSeparedLong(ids);
			Predicate p1 = root.get(Linea_.id).in(listaId);
			predicateList.add(p1);
		}

	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Linea> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Linea> root) throws Exception {
		Order a = criteriaBuilder.asc(root.get(Linea_.nome));
		// Order b =
		// criteriaBuilder.desc(root.get(Linea_.entityMarks).get(EntityMarksUUID_.dataCreazione));
		orderList.add(a);
	}

}
