package emlearning.em.backend.domain.service.english.reload.impl;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.constant.english.verb.VerbConstant;
import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;
import emlearning.em.backend.persistence.repository.english.verb.PresentJpaRepository;

@Service
public class ReloadVerbInTableImpl implements ReloadVerbInTableService {

	@Autowired
	private PresentJpaRepository verbJpaRepository;
	
	@Override
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadPresentVerbInTable();
	}

	@Override
	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.presentTime).stream().forEach(verb -> {
			if( !verbJpaRepository.existsByVerb(verb) ) {
				PresentEntity newVerb = new PresentEntity();
				newVerb.setVerb(verb);
				verbJpaRepository.save( newVerb );	
			}
		});		
	}

	@Override
	public void reloadPastVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.pastTime).stream().forEach(verb -> {
			if( !verbJpaRepository.existsByVerb(verb) ) {
				PresentEntity newVerb = new PresentEntity();
				newVerb.setVerb(verb);
				verbJpaRepository.save( newVerb );	
			}
		});		
	}

}
