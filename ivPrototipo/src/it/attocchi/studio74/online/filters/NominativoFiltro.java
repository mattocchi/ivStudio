package it.attocchi.studio74.online.filters;

import it.attocchi.jpa2.JPAEntityFilter;
import it.attocchi.studio74.online.api.NominativoAPI.RuoloContattoEnum;
import it.attocchi.studio74.online.entities.Linea_;
import it.attocchi.studio74.online.entities.Nominativo;
import it.attocchi.studio74.online.entities.Nominativo_;
import it.attocchi.utils.ListUtils;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public class NominativoFiltro extends JPAEntityFilter<Nominativo> {

	private RuoloContattoEnum ruoloContatto;
	private String username;
	private String ids;

	public RuoloContattoEnum getRuoloContatto() {
		return ruoloContatto;
	}

	public void setRuoloContatto(RuoloContattoEnum ruoloContatto) {
		this.ruoloContatto = ruoloContatto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public NominativoFiltro() {
		super();
	}

	public NominativoFiltro(RuoloContattoEnum ruoloContatto) {
		super();
		this.ruoloContatto = ruoloContatto;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public void buildWhere(EntityManagerFactory emf, List<Predicate> predicateList, CriteriaQuery<Nominativo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Nominativo> root) throws Exception {
		if (StringUtils.isNotBlank(semeRicerca)) {

			Predicate p1 = criteriaBuilder.like(root.get(Nominativo_.ragioneSociale), getSemeRicercaForLike());
			Predicate p2 = criteriaBuilder.like(root.get(Nominativo_.partitaIva), getSemeRicercaForLike());
			Predicate p3 = criteriaBuilder.like(root.get(Nominativo_.codiceFiscale), getSemeRicercaForLike());
			Predicate p4 = criteriaBuilder.like(root.get(Nominativo_.note), getSemeRicercaForLike());
			Predicate p5 = criteriaBuilder.like(root.get(Nominativo_.nome), getSemeRicercaForLike());
			Predicate p6 = criteriaBuilder.like(root.get(Nominativo_.cognome), getSemeRicercaForLike());
			Predicate p7 = criteriaBuilder.like(root.get(Nominativo_.userName), getSemeRicercaForLike());
			Predicate p8 = criteriaBuilder.like(root.get(Nominativo_.nomeVisualizzato), getSemeRicercaForLike());
			Predicate p9 = criteriaBuilder.like(root.get(Nominativo_.codice), getSemeRicercaForLike());

			Predicate or = criteriaBuilder.or(p1, p2, p3, p4, p5, p6, p7, p8, p9);
			predicateList.add(or);
		}

		if (ruoloContatto != null) {
			Predicate p1 = criteriaBuilder.like(root.get(Nominativo_.ruoli), getForLike(ruoloContatto.name()));
			predicateList.add(p1);
		}

		if (StringUtils.isNotBlank(username)) {
			Predicate p1 = criteriaBuilder.equal(root.get(Nominativo_.userName), username);
			predicateList.add(p1);
		}
		
		if (StringUtils.isNotBlank(ids)) {
			List<Long> listaId = ListUtils.fromCommaSeparedLong(ids);
			Predicate p1 = root.get(Nominativo_.id).in(listaId);
			predicateList.add(p1);
		}
	}

	@Override
	public void buildSort(List<Order> orderList, CriteriaQuery<Nominativo> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<Nominativo> root) throws Exception {
		Order a = criteriaBuilder.asc(root.get(Nominativo_.ragioneSociale));
		// Order b =
		// criteriaBuilder.desc(root.get(Nominativo_.entityMarks).get(EntityMarksUUID_.dataCreazione));
		orderList.add(a);
	}

}
