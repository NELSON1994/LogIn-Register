package springboot.spring.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.spring.entity.User;
import springboot.spring.service.userServiceImpl;

import javax.validation.Valid;

@RestController

@RequestMapping( value = "/register", method = RequestMethod.POST )
public class userController {


    public userServiceImpl userSer;


    @GetMapping( "/register" )
    public void registerUser(@Valid User user, BindingResult bindingResult) {
        User userExists = userSer.findUserByEmail(user.getEmail());

        //check if a user with the same email exist
        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists select another diffrent email!");
        }

        //check if the user has enterd all correct inputs

        if (bindingResult.hasErrors()) {

            bindingResult.reject("KINDLY ENTER CORRECT REGISTRATION DETAILS");
        }

        //we save the user

        userSer.saveUser(user);

    }

    @GetMapping( "/login" )

    public void logUser(@Valid String username, String password, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            bindingResult.reject("Your login details are invalid");
        }

        userSer.logInUserByUsernamePassword(username, password);


    }


    @GetMapping( "/display" )
    public void displayUserDetailsByEmail(String email) {

        userSer.findUserByEmail(email);


    }


}
