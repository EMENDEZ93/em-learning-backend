package emlearning.em.backend.domains.system.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.domains.system.role.constant.RoleNameConstant;
import emlearning.em.backend.domains.system.role.entity.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

	public Optional<RoleEntity> findByName(RoleNameConstant roleName);

	public abstract boolean existsByName(RoleNameConstant roleName);
	
}
