package emlearning.em.backend.domains.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlearning.em.backend.domains.system.entity.RoleEntity;
import emlearning.em.backend.domains.system.entity.RoleNameEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
	public Optional<RoleEntity> findByName(RoleNameEntity roleName);
}
