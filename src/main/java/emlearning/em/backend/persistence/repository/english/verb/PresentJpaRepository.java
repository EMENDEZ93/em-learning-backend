package emlearning.em.backend.persistence.repository.english.verb;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;

@Repository
public interface PresentJpaRepository extends JpaRepository<PresentEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);

	@Query(value = "select * from present where learned = false order by rand() limit 1", nativeQuery = true)
	public PresentEntity getRandomLearnVerb();

	@Transactional
	@Modifying
	@Query("update PresentEntity set learned = true where id = ?1")
	public void getPresentLearned(@Param("id") Long id);
	
	public abstract PresentEntity findByVerb(String verb);
}
