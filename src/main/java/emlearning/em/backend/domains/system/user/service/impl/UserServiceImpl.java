package emlearning.em.backend.domains.system.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import emlearning.em.backend.application.command.system.signup.model.SignUpCommand;
import emlearning.em.backend.domains.system.exception.SystemException;
import emlearning.em.backend.domains.system.role.constant.RoleNameConstant;
import emlearning.em.backend.domains.system.role.entity.RoleEntity;
import emlearning.em.backend.domains.system.role.repository.RoleEntityRepository;
import emlearning.em.backend.domains.system.user.entity.UserEntity;
import emlearning.em.backend.domains.system.user.repository.UserEntityRepository;
import emlearning.em.backend.domains.system.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired(required=false)
	private PasswordEncoder encoder;

	@Override
	public void register(SignUpCommand signUpCommand) throws SystemException {

		existsByUserName(signUpCommand);
		existsByEmail(signUpCommand);

		UserEntity usr = buildUser(signUpCommand);
		userEntityRepository.save(usr);

		Set<String> sentRolesOnRequest = signUpCommand.getRole();
		Set<RoleEntity> roles = new HashSet<>();

		sentRolesOnRequest.forEach(role -> {
			toAssginRoles(roles, role);
		});

		usr.setRoles(roles);
		userEntityRepository.save(usr);
	}

	private void existsByEmail(SignUpCommand signUpCommand) throws SystemException {
		if (userEntityRepository.existsByEmail(signUpCommand.getEmail())) {
			throw new SystemException("Fail -> Email is already in use!");
		}
	}

	private void existsByUserName(SignUpCommand signUpCommand) throws SystemException {
		if (userEntityRepository.existsByUsername(signUpCommand.getUsername())) {
			throw new SystemException("Fail -> Username is already taken!");
		}
	}

	private void toAssginRoles(Set<RoleEntity> roles, String role) {
		switch (role) {
		case "admin":
			RoleEntity adminRole = roleEntityRepository.findByName(RoleNameConstant.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(adminRole);
			break;

		case "pm":
			RoleEntity pmRole = roleEntityRepository.findByName(RoleNameConstant.ROLE_PM)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(pmRole);
			break;
		default:
			RoleEntity userRole = roleEntityRepository.findByName(RoleNameConstant.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}
	}

	private UserEntity buildUser(SignUpCommand signUpCommand) {
		return new UserEntity(signUpCommand.getName(), signUpCommand.getUsername(), signUpCommand.getEmail(),
				encoder.encode(signUpCommand.getPassword()));
	}

}
