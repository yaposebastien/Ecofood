package tech.attecoube.ecofood.service;

import tech.attecoube.ecofood.entity.User;
import tech.attecoube.ecofood.user.BoutiqueUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(BoutiqueUser crmUser);
}
