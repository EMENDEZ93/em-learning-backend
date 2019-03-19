package emlearning.em.backend.domains.english.practice.past.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.application.english.practice.past.command.model.PastCommand;
import emlearning.em.backend.domains.english.practice.past.entity.PastEntity;

@Repository
public interface PastJpaRepository extends JpaRepository<PastEntity, Serializable> {

	public abstract boolean existsByVerb(String verb);

	public abstract boolean existsByVerbAndUsername(String verb, String username);
	
	@Query(value = "select * from past where learned = false and username=?1 order by rand() limit 1", nativeQuery = true)
	public PastEntity getRandomLearnVerb(@Param("username") String username);

	@Transactional
	@Modifying
	@Query(value = "update past set learned = true where username=?1 and id=?2", nativeQuery = true)	
	public void changePastLearned(@Param("username") String  username, @Param("verbId") Long verbId);
	
}
