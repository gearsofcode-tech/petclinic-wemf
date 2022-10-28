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
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.repository.PetTypeRepository;
import tech.gearsofcode.petclinic.web.dto.PetTypeCriteria;
import org.springframework.stereotype.Component;
@Component
public class PetTypeRepositoryJPA implements PetTypeRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (PetType pettype){
		em.persist(pettype);
	}



	@Override
	public void delete (PetType pettype){
		em.remove(pettype);
	} 



	@Override
	public void update (PetType pettype){
		em.persist(pettype);
	}



	@Override
	public PetType findById(int id){
		return em.find(PetType.class, id);
	}



	@Override
	public List<PetType> findByCriteria(PetTypeCriteria petTypeCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PetType> cq = cb.createQuery(PetType.class);
		Root<PetType> root = cq.from(PetType.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, petTypeCriteria);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<PetType> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(PetTypeCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<PetType> pettype = cq.from(PetType.class);
		cq.select(cb.count(pettype));
		List<Predicate> predicates = getPredicates(cb, pettype, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<PetType> root, PetTypeCriteria filter){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Predicate> lstPredicate = new LinkedList<Predicate>();
		if (filter.getName() != null){
				if (!filter.getName().isEmpty()){
					lstPredicate.add(cb.like(root.get("name"), "%"+filter.getName()+"%"));
				}
		}
		return lstPredicate;
	}



	@Override
	public List<PetType> findAll(){
		String jpql = "from PetType";
		TypedQuery<PetType> query = em.createQuery(jpql, PetType.class);
		return query.getResultList();
	}
}
