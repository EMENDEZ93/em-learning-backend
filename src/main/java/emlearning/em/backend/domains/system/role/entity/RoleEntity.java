package emlearning.em.backend.domains.system.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import emlearning.em.backend.domains.system.role.constant.RoleNameConstant;

@Entity
@Table(name = "role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RoleNameConstant name;

	public RoleEntity() {
	}

	public RoleEntity(RoleNameConstant name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleNameConstant getName() {
		return name;
	}

	public void setName(RoleNameConstant name) {
		this.name = name;
	}

}
