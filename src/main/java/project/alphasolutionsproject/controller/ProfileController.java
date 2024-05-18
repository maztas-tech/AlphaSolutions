package project.alphasolutionsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.alphasolutionsproject.model.Profile;
import project.alphasolutionsproject.service.ProfileService;

@Controller
@RequestMapping("/logIn")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    public String logInForm(Profile profile, Model model){
        model.addAttribute("profile",new Profile());
        return "logIn";
    }

    @PostMapping("")
    public String logInPost(@ModelAttribute Profile profile){
        //TODO Create if statement so the user is not being redirected if the password is incorrect
        profileService.logIn(profile);
        if (profile.getUsername().isEmpty() || profile.getPassword().isEmpty()){
            return "redirect:/logIn";
        }
        return "redirect:/alphasolutions";
    }

}
