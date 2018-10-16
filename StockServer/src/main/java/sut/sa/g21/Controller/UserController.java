
package sut.sa.g21.Controller;

import sut.sa.g21.Entity.User;
import sut.sa.g21.Repository.UserRepository;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/Register")
    public User registerUser(@RequestBody() Map<String,Object> body) {
        User regis = new User(Integer.valueOf(body.get("Gender").toString()));
        regis.setUserUsername(body.get("Username").toString());
        regis.setUserPassword(body.get("Password").toString());
        regis.setUserFirstName(body.get("FirstName").toString());
        regis.setUserLastName(body.get("LastName").toString());
        regis.setUserAddress(body.get("Address").toString());
        regis.setUserEmail(body.get("Email").toString());
        regis.setUserTelephone(body.get("Telephone").toString());
        
        return userRepository.save(regis);
    }

}
