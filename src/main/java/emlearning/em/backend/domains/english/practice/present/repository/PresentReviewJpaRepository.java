package emlearning.em.backend.domains.english.practice.present.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.domains.english.practice.present.entity.PresentReviewEntity;

@Repository
public interface PresentReviewJpaRepository extends JpaRepository<PresentReviewEntity, Serializable> {

	@Transactional
	@Modifying
	@Query(value = "delete from present_review where username=?1", nativeQuery = true)	
	public void resetReviewByUsername(@Param("username") String username);
	
}
