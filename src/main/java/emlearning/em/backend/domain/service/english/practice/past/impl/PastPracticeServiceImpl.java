package emlearning.em.backend.domain.service.english.practice.past.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.service.english.practice.past.PastPracticeService;
import emlearning.em.backend.persistence.repository.english.verb.PastJpaRepository;

@Service 
public class PastPracticeServiceImpl implements PastPracticeService {

	@Autowired
	private PastJpaRepository pastJpaRepository;
	
	@Override
	public String getVerb() {
		Long a = (long) 1;
		return pastJpaRepository.getOne(a).getVerb();
	}

}
