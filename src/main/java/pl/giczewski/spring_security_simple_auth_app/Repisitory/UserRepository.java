package pl.giczewski.spring_security_simple_auth_app.Repisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.giczewski.spring_security_simple_auth_app.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
}
