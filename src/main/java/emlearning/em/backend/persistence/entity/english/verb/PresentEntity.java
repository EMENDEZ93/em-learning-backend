package emlearning.em.backend.persistence.entity.english.verb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@PrePersist
	public void prePersist() {
		learned = false;
	}

	public PresentEntity(String verb) {
		this.verb = verb;
	}

	public boolean isLearned() {
		return learned;
	}

	public void setLearned(boolean learned) {
		this.learned = learned;
	}

	public Long getId() {
		return id;
	}

	public String getVerb() {
		return verb;
	}

}
