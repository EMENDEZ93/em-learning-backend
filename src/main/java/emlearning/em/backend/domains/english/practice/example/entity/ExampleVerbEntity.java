package emlearning.em.backend.domains.english.practice.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "example_verb")
public class ExampleVerbEntity implements Serializable {

	private static final long serialVersionUID = 371306800799380123L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sentence;

	private String auxiliaryId;

	private String help;

	private String verb;

	private boolean learned;

	public boolean isLearned() {
		return learned;
	}

	public void setLearned(boolean learned) {
		this.learned = learned;
	}

	@PrePersist
	public void prePersist() {
		learned = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getAuxiliaryId() {
		return auxiliaryId;
	}

	public void setAuxiliaryId(String auxiliaryId) {
		this.auxiliaryId = auxiliaryId;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

}
