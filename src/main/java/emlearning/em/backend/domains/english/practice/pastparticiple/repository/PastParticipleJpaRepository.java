package emlearning.em.backend.domains.english.practice.pastparticiple.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.domains.english.practice.pastparticiple.entity.PastParticipleEntity;

@Repository
public interface PastParticipleJpaRepository extends JpaRepository<PastParticipleEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);
	
}
