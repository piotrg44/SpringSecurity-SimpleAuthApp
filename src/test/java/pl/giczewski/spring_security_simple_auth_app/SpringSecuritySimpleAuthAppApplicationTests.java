package pl.giczewski.spring_security_simple_auth_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.giczewski.spring_security_simple_auth_app.Model.User;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.UserRepository;
import pl.giczewski.spring_security_simple_auth_app.Service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringSecuritySimpleAuthAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
