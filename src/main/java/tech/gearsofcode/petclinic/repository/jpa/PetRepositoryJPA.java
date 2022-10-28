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
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.repository.PetRepository;
import tech.gearsofcode.petclinic.web.dto.PetCriteria;
import org.springframework.stereotype.Component;
@Component
public class PetRepositoryJPA implements PetRepository {
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void insert (Pet pet){
		em.persist(pet);
	}



	@Override
	public void delete (Pet pet){
		em.remove(pet);
	} 



	@Override
	public void update (Pet pet){
		em.persist(pet);
	}



	@Override
	public Pet findById(int id){
		return em.find(Pet.class, id);
	}



	@Override
	public List<Pet> findByCriteria(PetCriteria petCriteria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);
		Root<Pet> root = cq.from(Pet.class);
		cq.select(root);
		List<Predicate> predicates = getPredicates(cb, root, petCriteria);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Pet> query = em.createQuery(cq);
		return query.getResultList();
	}



	@Override
	public Long getTotalRecords(PetCriteria filter){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Pet> pet = cq.from(Pet.class);
		cq.select(cb.count(pet));
		List<Predicate> predicates = getPredicates(cb, pet, filter);
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> query = em.createQuery(cq);
		return query.getSingleResult();
	}



	private List<Predicate> getPredicates (CriteriaBuilder cb, Root<Pet> root, PetCriteria filter){
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
	public List<Pet> findAll(){
		String jpql = "from Pet";
		TypedQuery<Pet> query = em.createQuery(jpql, Pet.class);
		return query.getResultList();
	}
}
