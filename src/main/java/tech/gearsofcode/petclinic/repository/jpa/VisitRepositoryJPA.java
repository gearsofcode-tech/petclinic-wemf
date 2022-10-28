package tech.gearsofcode.petclinic.repository.jpa;
import java.util.List;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.repository.VisitRepository;
import tech.gearsofcode.petclinic.web.dto.VisitCriteria;
import org.springframework.stereotype.Component;
@Component
public class VisitRepositoryJPA implements VisitRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (Visit visit){
		em.persist(visit);
	}



	@Override
	public void delete (Visit visit){
		em.remove(visit);
	} 



	@Override
	public void update (Visit visit){
		em.persist(visit);
	}



	@Override
	public Visit findById(int id){
		return em.find(Visit.class, id);
	}



	@Override
	public List<Visit> findByCriteria(VisitCriteria visitCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Visit> cq = cb.createQuery(Visit.class);
		Root<Visit> root = cq.from(Visit.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, visitCriteria);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Visit> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(VisitCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Visit> visit = cq.from(Visit.class);
		cq.select(cb.count(visit));
		List<Predicate> predicates = getPredicates(cb, visit, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<Visit> root, VisitCriteria filter){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Predicate> lstPredicate = new LinkedList<Predicate>();

		if (filter.getDescription() != null){
				if (!filter.getDescription().isEmpty()){
					lstPredicate.add(cb.like(root.get("description"), "%"+filter.getDescription()+"%"));
				}
		}
		return lstPredicate;
	}



	@Override
	public List<Visit> findAll(){
		String jpql = "from Visit";
		TypedQuery<Visit> query = em.createQuery(jpql, Visit.class);
		return query.getResultList();
	}
}
