package pl.skoltun.SpringBoot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.skoltun.SpringBoot.repository.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    private UserController userController;

    @GetMapping("/")
    public String get(Authentication authentication) {
        return authentication.getName();
    }

    @PutMapping("/{username}")
    public String create(@PathVariable String username) {
        User user = userController.create(username);
        return "Created " + user.getUsername();
    }


}