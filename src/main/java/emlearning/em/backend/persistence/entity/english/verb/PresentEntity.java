package emlearning.em.backend.persistence.entity.english.verb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "present")
public class PresentEntity implements Serializable {

	private static final long serialVersionUID = -1013405795486000283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String verb;

	private boolean learned;

	@OneToMany(fetch=FetchType.LAZY)
	private List<ExampleVerbEntity> examples;

	@OneToOne
	private PastEntity past;

	@OneToOne
	private PastParticipleEntity pastPartiple;

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

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public boolean isLearned() {
		return learned;
	}

	public void setLearned(boolean learned) {
		this.learned = learned;
	}

	public PastEntity getPast() {
		return past;
	}

	public void setPast(PastEntity past) {
		this.past = past;
	}

	public PastParticipleEntity getPastPartiple() {
		return pastPartiple;
	}

	public void setPastPartiple(PastParticipleEntity pastPartiple) {
		this.pastPartiple = pastPartiple;
	}

	public List<ExampleVerbEntity> getExamples() {
		return examples;
	}

	public void setExample(ExampleVerbEntity example) {
		this.examples.add(example);
	}

}
