package pl.giczewski.spring_security_simple_auth_app.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.giczewski.spring_security_simple_auth_app.Model.User;
import pl.giczewski.spring_security_simple_auth_app.Service.UserService;

import java.security.Principal;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model){
        model.addAttribute("name", principal.getName());
        return "hello";
    }

    @GetMapping("/singUp")
    public String singUp(Model model){
        model.addAttribute("user", new User());
        return "sing_up";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user){
        System.out.println(user);
        userService.addUser(user);
        return "sing_up";
    }


}
