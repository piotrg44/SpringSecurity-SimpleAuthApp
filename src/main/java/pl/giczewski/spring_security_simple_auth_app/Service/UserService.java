package pl.giczewski.spring_security_simple_auth_app.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.giczewski.spring_security_simple_auth_app.Model.Token;
import pl.giczewski.spring_security_simple_auth_app.Model.User;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.TokenRepository;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.UserRepository;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {


    private TokenRepository tokenRepository;

    private MailService mailService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        sendToken(user);
    }

    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepository.save(token);
        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(), "Potwierdz email", "Potwierdz swój email klinając w link: " + url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


}
