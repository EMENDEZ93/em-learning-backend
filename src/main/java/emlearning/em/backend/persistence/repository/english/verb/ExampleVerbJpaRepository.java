package emlearning.em.backend.persistence.repository.english.verb;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.persistence.entity.english.verb.ExampleVerbEntity;

@Repository
public interface ExampleVerbJpaRepository extends JpaRepository<ExampleVerbEntity, Serializable> {

	@Query(value = "select * from example_verb where learned = false and verb = ?1 order by rand() limit 1", nativeQuery = true)
	public ExampleVerbEntity getRandomExampleVerb(@Param("verb") String placa);
	
	public abstract boolean existsByAuxiliaryId(String verb);
	
}
