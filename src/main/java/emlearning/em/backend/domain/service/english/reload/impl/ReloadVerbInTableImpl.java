package emlearning.em.backend.domain.service.english.reload.impl;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.constant.english.verb.VerbConstant;
import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;
import emlearning.em.backend.persistence.repository.english.verb.VerbJpaRepository;

@Service
public class ReloadVerbInTableImpl implements ReloadVerbInTableService {

	@Autowired
	private VerbJpaRepository verbJpaRepository;
	
	@Override
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadPresentVerbInTable();
	}

	@Override
	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.presentTime).stream().forEach(verb -> {
			if( !verbJpaRepository.existsByVerb(verb) ) {
				verbJpaRepository.save(new PresentEntity(verb) );	
			}
		});		
	}

}
