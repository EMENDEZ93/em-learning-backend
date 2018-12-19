package emlearning.em.backend.persistence.repository.english.verb;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.persistence.entity.english.verb.PastParticipleEntity;

@Repository
public interface PastParticipleJpaRepository extends JpaRepository<PastParticipleEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);
	
}
