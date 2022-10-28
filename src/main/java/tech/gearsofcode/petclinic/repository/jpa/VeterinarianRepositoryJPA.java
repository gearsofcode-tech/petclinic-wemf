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
import tech.gearsofcode.petclinic.domain.Veterinarian;
import tech.gearsofcode.petclinic.repository.VeterinarianRepository;
import tech.gearsofcode.petclinic.web.dto.VeterinarianCriteria;
import org.springframework.stereotype.Component;
@Component
public class VeterinarianRepositoryJPA implements VeterinarianRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (Veterinarian veterinarian){
		em.persist(veterinarian);
	}



	@Override
	public void delete (Veterinarian veterinarian){
		em.remove(veterinarian);
	} 



	@Override
	public void update (Veterinarian veterinarian){
		em.persist(veterinarian);
	}



	@Override
	public Veterinarian findById(int id){
		return em.find(Veterinarian.class, id);
	}



	@Override
	public List<Veterinarian> findByCriteria(VeterinarianCriteria veterinarianCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Veterinarian> cq = cb.createQuery(Veterinarian.class);
		Root<Veterinarian> root = cq.from(Veterinarian.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, veterinarianCriteria);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Veterinarian> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(VeterinarianCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Veterinarian> veterinarian = cq.from(Veterinarian.class);
		cq.select(cb.count(veterinarian));
		List<Predicate> predicates = getPredicates(cb, veterinarian, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<Veterinarian> root, VeterinarianCriteria filter){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Predicate> lstPredicate = new LinkedList<Predicate>();

		if (filter.getFirstName() != null){
				if (!filter.getFirstName().isEmpty()){
					lstPredicate.add(cb.like(root.get("firstName"), "%"+filter.getFirstName()+"%"));
				}
		}
		if (filter.getLastName() != null){
				if (!filter.getLastName().isEmpty()){
					lstPredicate.add(cb.like(root.get("lastName"), "%"+filter.getLastName()+"%"));
				}
		}
		return lstPredicate;
	}



	@Override
	public List<Veterinarian> findAll(){
		String jpql = "from Veterinarian";
		TypedQuery<Veterinarian> query = em.createQuery(jpql, Veterinarian.class);
		return query.getResultList();
	}
}
