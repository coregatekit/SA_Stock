
package sut.sa.g21.Controller;

import sut.sa.g21.Entity.User;
import sut.sa.g21.Repository.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/Users")
    public Collection<User> users() {
        return userRepository.findAll();
    }

    @PostMapping("/registerAccount/{regUsername}/{regPassword}/{regFname}/{regLName}/{regGender}/{regEmail}/{regTelephone}")
    public User registerAccount(@PathVariable String regUsername, @PathVariable String regPassword, @PathVariable String regFName,
        @PathVariable String regLName, @PathVariable int regGender, @PathVariable String regEmail, @PathVariable String regTelephone) {
            User newUser = new User(regGender);
			newUser.setUserUsername(regUsername);
			newUser.setUserPassword(regPassword);
			newUser.setUserFirstName(regFName);
			newUser.setUserLastName(regLName);
			newUser.setUserEmail(regEmail);
			newUser.setUserTelephone(regTelephone);
			return userRepository.save(newUser);
    }
}
