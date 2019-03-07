package emlearning.em.backend.infrastructure.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.system.user.entity.UserEntity;
import emlearning.em.backend.domains.system.user.repository.UserEntityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserEntityRepository userEntityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userEntityRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return UserPrinciple.build(user);
	}

}
