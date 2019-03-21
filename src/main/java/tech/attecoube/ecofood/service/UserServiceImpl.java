package tech.attecoube.ecofood.service;

import tech.attecoube.ecofood.dao.RoleDao;
import tech.attecoube.ecofood.dao.UserDao;
import tech.attecoube.ecofood.entity.Role;
import tech.attecoube.ecofood.entity.User;
import tech.attecoube.ecofood.user.BoutiqueUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(BoutiqueUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
                user.setNom_boutique(crmUser.getNom_boutique());
                user.setNom_proprietaire_boutique(crmUser.getNom_proprietaire_boutique());
                user.setTelephone_boutique(crmUser.getTelephone_boutique());
                user.setEmail_boutique(crmUser.getEmail_boutique());
                user.setQuartier_boutique(crmUser.getQuartier_boutique());

		// give user default role of "BOUTIQUE"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_BOUTIQUE")));

		 // save user in the database
		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Nom utilisateur ou mot de passe incorrect.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
