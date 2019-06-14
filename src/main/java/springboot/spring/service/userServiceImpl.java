package springboot.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import springboot.spring.entity.User;
import springboot.spring.repository.userRepository;

public class userServiceImpl {

    @Autowired
    userRepository userRepository;

    private User user;

    public User findUserByEmail(String email) {

        return userRepository.findUserByEmail(email);
    }


    public void saveUser(User user) {
//validation of the inputs
        if (user.getEmail().isEmpty() || user.getUsername().isEmpty()) {
            System.out.println("fill all required information");

        } else if (user.getPassword() != user.getConfirmPassword()) {
            System.out.println("YOUR PASSWORDS DOES NOT MATCH");

        } else {
            user.setFirstname("firstname");
            user.setLastname("lastname");
            user.setEmail("email");
            user.setContact("contact");
            user.setUsername("username");
            user.setPassword("password");
            userRepository.saveUser(user);
            System.out.println("Successfully registered");
        }
    }

    public void logInUserByUsernamePassword(String username, String password) {
        user = userRepository.findByUsername(username);
        user = userRepository.findUserByPassword(password);
        if (user == null) {
            throw new UsernameNotFoundException(username);

        }
        userRepository.findByUsername(username);

    }
}
