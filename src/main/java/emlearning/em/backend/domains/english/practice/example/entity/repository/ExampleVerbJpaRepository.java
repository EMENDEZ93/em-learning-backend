package emlearning.em.backend.domains.english.practice.example.entity.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.domains.english.practice.example.entity.ExampleVerbEntity;

@Repository
public interface ExampleVerbJpaRepository extends JpaRepository<ExampleVerbEntity, Serializable> {

	@Query(value = "select * from example_verb where learned = false and verb = ?1 order by rand() limit 1", nativeQuery = true)
	public ExampleVerbEntity getRandomExampleVerb(@Param("verb") String placa);
	
	public abstract boolean existsByAuxiliaryId(String verb);

	@Transactional
	@Modifying
	@Query("update ExampleVerbEntity set learned = true where auxiliaryId = ?1")
	public void getChangePresentExampleVerbLearned(@Param("auxiliaryId") String auxiliaryId);
	
}
