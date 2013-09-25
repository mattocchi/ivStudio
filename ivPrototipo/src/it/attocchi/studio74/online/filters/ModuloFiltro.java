package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.entities.Modulo;
import it.attocchi.studio74.online.entities.Modulo_;
import it.attocchi.utils.ListUtils;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class ModuloFiltro extends JPAEntityFilter<Modulo> {

	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Modulo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Modulo> root) throws Exception {
		if (StringUtils.isNotBlank(semeRicerca)) {
			Predicate p1 = criteriaBuilder.like(root.get(Modulo_.nome), getSemeRicercaForLike());
			// Predicate or = criteriaBuilder.or(p1);
			predicateList.add(p1);
		}

		if (StringUtils.isNotBlank(ids)) {
			List<Long> listaId = ListUtils.fromCommaSeparedLong(ids);
			Predicate p1 = root.get(Modulo_.id).in(listaId);
			predicateList.add(p1);
		}

		if (StringUtils.isNotBlank(nome)) {
			Predicate p1 = criteriaBuilder.equal(root.get(Modulo_.nome), getNome());
			predicateList.add(p1);
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Modulo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Modulo> root) throws Exception {
		Order a = criteriaBuilder.asc(root.get(Modulo_.nome));
		// Order b =
		// criteriaBuilder.desc(root.get(Modulo_.entityMarks).get(EntityMarksUUID_.dataCreazione));
		orderList.add(a);
	}

}
