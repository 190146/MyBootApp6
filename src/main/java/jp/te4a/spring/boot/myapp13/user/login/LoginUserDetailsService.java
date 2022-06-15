package jp.te4a.spring.boot.myapp13.user.login;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.user.UserBean;
import jp.te4a.spring.boot.myapp13.user.login.LoginUserDetails;
import jp.te4a.spring.boot.myapp13.user.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBean> opt = userRepository.findById(username);
        UserBean user = opt.orElseThrow(() -> new UsernameNotFoundException("The requested user is not found."));
        return new LoginUserDetails(user);
    }
}
