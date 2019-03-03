package emlearning.em.backend.domains.english.practice.past.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.english.practice.past.repository.PastJpaRepository;
import emlearning.em.backend.domains.english.practice.past.service.PastPracticeService;

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
