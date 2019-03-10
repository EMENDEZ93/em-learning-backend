package emlearning.em.backend.domains.english.practice.present.service;

import emlearning.em.backend.application.english.practice.present.query.model.PresentReviewQuery;
import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;

public interface PresentPracticeService {

	public PresentEntity getRandomLearnVerb(String username);

	public PresentReviewQuery getRandomReviewVerb(String username);
	
	public void getChangePresentLearned(Long id);
	
}
