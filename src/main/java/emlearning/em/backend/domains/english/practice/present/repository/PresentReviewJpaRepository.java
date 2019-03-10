package emlearning.em.backend.domains.english.practice.present.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.domains.english.practice.present.entity.PresentReviewEntity;

@Repository
public interface PresentReviewJpaRepository extends JpaRepository<PresentReviewEntity, Serializable> {

}
