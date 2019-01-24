package pl.skoltun.SpringBoot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import pl.skoltun.SpringBoot.repository.User;
import pl.skoltun.SpringBoot.repository.UserAuthority;
import pl.skoltun.SpringBoot.repository.UserDetailsRepository;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserDetailsRepository detailsRepository;

    public User create(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode("12345"));
        UserAuthority authority = new UserAuthority("USER", user);
        user.setAuthorities(List.of(authority));
        detailsRepository.create(user);
        return user;
    }
}
