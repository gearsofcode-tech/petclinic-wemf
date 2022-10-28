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
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.repository.SpecialtyRepository;
import tech.gearsofcode.petclinic.web.dto.SpecialtyCriteria;
import org.springframework.stereotype.Component;
@Component
public class SpecialtyRepositoryJPA implements SpecialtyRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (Specialty specialty){
		em.persist(specialty);
	}



	@Override
	public void delete (Specialty specialty){
		em.remove(specialty);
	} 



	@Override
	public void update (Specialty specialty){
		em.persist(specialty);
	}



	@Override
	public Specialty findById(int id){
		return em.find(Specialty.class, id);
	}



	@Override
	public List<Specialty> findByCriteria(SpecialtyCriteria specialtyCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Specialty> cq = cb.createQuery(Specialty.class);
		Root<Specialty> root = cq.from(Specialty.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, specialtyCriteria);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Specialty> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(SpecialtyCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Specialty> specialty = cq.from(Specialty.class);
		cq.select(cb.count(specialty));
		List<Predicate> predicates = getPredicates(cb, specialty, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<Specialty> root, SpecialtyCriteria filter){
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
	public List<Specialty> findAll(){
		String jpql = "from Specialty";
		TypedQuery<Specialty> query = em.createQuery(jpql, Specialty.class);
		return query.getResultList();
	}
}
