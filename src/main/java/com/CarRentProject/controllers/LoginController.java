package com.CarRentProject.controllers;

import com.CarRentProject.models.User;
import com.CarRentProject.service.CarServiceImpl;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String checkLoginData(HttpSession session, @ModelAttribute("user") @Valid User loginData) {
        User user = usersService.getUserByLoginAndPasswordAndRoles(loginData.getLogin(), loginData.getPassword(), loginData.getRoles());
        if (user != null) {
            if("admin".equals(user.getRoles().getRole())){
                return "redirect:/admin";
            }
            session.setAttribute("user", user);
            return "redirect:/my-cars";
        }
        else {
            return "redirect:/login?error=user_not_found";
        }

    }

}
