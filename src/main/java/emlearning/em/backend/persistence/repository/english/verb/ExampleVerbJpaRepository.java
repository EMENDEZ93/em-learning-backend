package emlearning.em.backend.persistence.repository.english.verb;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.persistence.entity.english.verb.ExampleVerbEntity;

@Repository
public interface ExampleVerbJpaRepository extends JpaRepository<ExampleVerbEntity, Serializable> {

	public abstract boolean existsByAuxiliaryId(String verb);
	
}
