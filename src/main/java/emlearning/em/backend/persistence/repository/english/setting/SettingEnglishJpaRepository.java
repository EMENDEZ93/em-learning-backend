package emlearning.em.backend.persistence.repository.english.setting;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.persistence.entity.english.setting.SettingEnglishEntity;

@Repository
public interface SettingEnglishJpaRepository extends JpaRepository<SettingEnglishEntity, Serializable> {

	@Query("select setting.repeatToLearnedVerb from SettingEnglishEntity setting where setting.id=1")
	public int getRepeatToLearnedVerbNumber();

	@Query("select setting.repeatToLearnedPresentExampleVerb from SettingEnglishEntity setting where setting.id=1")
	public int getRepeatToLearnedPresentExampleVerbNumber();
	
}
