package emlearning.em.backend.domains.english.practice.present.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;

@Repository
public interface PresentJpaRepository extends JpaRepository<PresentEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);

	public abstract boolean existsByVerbAndUsername(String verb, String username);
	
	@Query(value = "select * from present where learned = false and username=?1 order by rand() limit 1", nativeQuery = true)
	public PresentEntity getRandomLearnVerb(@Param("username") String username);

	@Transactional
	@Modifying
	@Query("update PresentEntity set learned = true where id = ?1")
	public void getPresentLearned(@Param("id") Long id);
	
	public abstract PresentEntity findByVerb(String verb);

	@Query(value = "select * from present pre where pre.id not in (select rev.verb_id from present_review rev) having learned=true and username=?1 order by rand() limit 1;", nativeQuery = true)	
	public PresentEntity getRandomReviewVerb(String username);
	
}
