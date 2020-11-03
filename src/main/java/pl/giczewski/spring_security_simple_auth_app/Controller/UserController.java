package pl.giczewski.spring_security_simple_auth_app.Controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.giczewski.spring_security_simple_auth_app.Model.Token;
import pl.giczewski.spring_security_simple_auth_app.Model.User;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.TokenRepository;
import pl.giczewski.spring_security_simple_auth_app.Repisitory.UserRepository;
import pl.giczewski.spring_security_simple_auth_app.Service.UserService;


import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public UserController(UserService userService, UserRepository userRepository, TokenRepository tokenRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return "hello";
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {
        model.addAttribute("user", new User());
        return "sing-up";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "sing-up";
    }

    @GetMapping("/token")
    public String singup(@RequestParam String value) {
        Token byValue = tokenRepository.findByValue(value);
        User appUser = byValue.getUser();
        appUser.setEnabled(true);
        userRepository.save(appUser);
        return "hello";
    }
}
