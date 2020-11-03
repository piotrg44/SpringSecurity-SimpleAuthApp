package pl.giczewski.spring_security_simple_auth_app.Repisitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.giczewski.spring_security_simple_auth_app.Model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByValue(String value);
}