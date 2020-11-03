package pl.giczewski.spring_security_simple_auth_app.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    UserRepository userRepository;

    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(userRepository.getByUsername(s));
        return userRepository.getByUsername(s);
    }
}
