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
import project.alphasolutionsproject.service.RoleService;

@Controller
@RequestMapping("/logIn")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String logInForm(Profile profile, Model model){
        model.addAttribute("profile",new Profile());
        return "logIn";
    }

    @PostMapping("")
    public String logInPost(@ModelAttribute Profile profile){
        Profile profile1 = profileService.logIn(profile);
        System.out.println(profile);

        if (profile1 == null){
            return "redirect:/logIn";
        }
        return "redirect:/alphasolutions";
    }

    @GetMapping("/create")
    public String registrerForm(Model model){
        model.addAttribute("profile", new Profile());
        model.addAttribute("roleList", roleService.showRoles());
        return "registrer";
    }

    @PostMapping("/create")
    public String registrer(@ModelAttribute Profile profile){
        profileService.registrer(profile);
        System.out.println(profile);
        return "redirect:/alphasolutions";
    }

}
