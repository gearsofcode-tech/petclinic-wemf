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
import tech.gearsofcode.petclinic.domain.Owner;
import tech.gearsofcode.petclinic.repository.OwnerRepository;
import tech.gearsofcode.petclinic.web.dto.OwnerCriteria;
import org.springframework.stereotype.Component;
@Component
public class OwnerRepositoryJPA implements OwnerRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (Owner owner){
		em.persist(owner);
	}



	@Override
	public void delete (Owner owner){
		em.remove(owner);
	} 



	@Override
	public void update (Owner owner){
		em.persist(owner);
	}



	@Override
	public Owner findById(int id){
		return em.find(Owner.class, id);
	}



	@Override
	public List<Owner> findByCriteria(OwnerCriteria ownerCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Owner> cq = cb.createQuery(Owner.class);
		Root<Owner> root = cq.from(Owner.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, ownerCriteria);
		if (!predicates.isEmpty()) {
			cq.where(predicates.toArray(new Predicate[predicates.size()]));
		}
		TypedQuery<Owner> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(OwnerCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Owner> owner = cq.from(Owner.class);
		cq.select(cb.count(owner));
		List<Predicate> predicates = getPredicates(cb, owner, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<Owner> root, OwnerCriteria filter){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Predicate> lstPredicate = new LinkedList<Predicate>();
		if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()){
				if (!filter.getFirstName().isEmpty()){
					lstPredicate.add(cb.like(root.get("firstName"), "%"+filter.getFirstName()+"%"));
				}
		}
		if (filter.getLastName() != null && !filter.getLastName().isEmpty()){
				if (!filter.getLastName().isEmpty()){
					lstPredicate.add(cb.like(root.get("lastName"), "%"+filter.getLastName()+"%"));
				}
		}
	
		return lstPredicate;
	}



	@Override
	public List<Owner> findAll(){
		String jpql = "from Owner";
		TypedQuery<Owner> query = em.createQuery(jpql, Owner.class);
		return query.getResultList();
	}
}
