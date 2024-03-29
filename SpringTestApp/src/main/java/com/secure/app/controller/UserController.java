package com.secure.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.secure.app.User.Service.UserService;
import com.secure.app.model.User;
import com.secure.app.service.SecurityService;
import com.secure.app.validator.UserValidator;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
    //@Autowired
    private UserService userService;

    //@Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    public UserController(UserService userService, SecurityService securityService) {
    	super();
    	this.userService = userService;
    	this.securityService = securityService;
    }

	
	
	  @GetMapping("/registration") 
	  public String registration(Model model) {
		  model.addAttribute("userForm", new User()); 
		  System.out.println("Here");
		  return "registration"; 
	  }
	 
	 

	
	  @PostMapping("/registration") 
	  public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
	 userValidator.validate(userForm, bindingResult);
	  System.out.println("Here too");
	  if (bindingResult.hasErrors()) {
		  
		  for(ObjectError err : bindingResult.getAllErrors())
		  {
			  System.out.println(err.toString());
		  }
		  return "registration"; 
	  }
	  
	  userService.save(userForm);
	  securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
	  
	  return "redirect:/welcome"; 
	}
	 

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login-page";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
