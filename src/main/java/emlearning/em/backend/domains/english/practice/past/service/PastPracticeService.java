package emlearning.em.backend.domains.english.practice.past.service;

import emlearning.em.backend.domains.english.practice.past.entity.PastEntity;

public interface PastPracticeService {

	public String getVerb();
	
	public PastEntity getRandomLearnVerb(String username);
	
}
