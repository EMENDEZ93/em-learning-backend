package emlearning.em.backend.domains.english.practice.past.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.domains.english.practice.past.entity.PastEntity;

@Repository
public interface PastJpaRepository extends JpaRepository<PastEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);

}
