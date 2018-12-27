package emlearning.em.backend.domain.service.english.reload.impl;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.constant.english.verb.VerbConstant;
import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;
import emlearning.em.backend.persistence.entity.english.verb.PastEntity;
import emlearning.em.backend.persistence.entity.english.verb.PastParticipleEntity;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;
import emlearning.em.backend.persistence.repository.english.verb.PastJpaRepository;
import emlearning.em.backend.persistence.repository.english.verb.PastParticipleJpaRepository;
import emlearning.em.backend.persistence.repository.english.verb.PresentJpaRepository;

@Service
public class ReloadVerbInTableImpl implements ReloadVerbInTableService {

	@Autowired
	private PresentJpaRepository presentJpaRepository;

	@Autowired
	private PastJpaRepository pastJpaRepository;

	@Autowired
	private PastParticipleJpaRepository pastParticipleJpaRepository;

	@Override
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadPresentVerbInTable();
	}

	@Override
	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.presentTime).stream().forEach(verbDto -> {
			if (!presentJpaRepository.existsByVerb(verbDto.getPresent())) {

				try {
					PresentEntity newVerb = new PresentEntity();
					newVerb.setVerb(verbDto.getPresent());
					newVerb.setPast(reloadPastVerbInTable(verbDto.getPast()));
					newVerb.setPastPartiple(reloadPastParticipleVerbInTable(verbDto.getPastParticiple()));
					presentJpaRepository.save(newVerb);

				} catch (InvalidFormatException | IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	@Override
	public PastEntity reloadPastVerbInTable(String pastVerb) throws InvalidFormatException, IOException {
		PastEntity newVerb = new PastEntity();
		newVerb.setVerb(pastVerb);
		return pastJpaRepository.save(newVerb);
	}

	@Override
	public PastParticipleEntity reloadPastParticipleVerbInTable(String pastParticipleVerb)
			throws InvalidFormatException, IOException {
		PastParticipleEntity newVerb = new PastParticipleEntity();
		newVerb.setVerb(pastParticipleVerb);
		return pastParticipleJpaRepository.save(newVerb);
	}

}
