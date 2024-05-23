package project.alphasolutionsproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String logInForm(Model model, HttpSession session, Profile profile){
        model.addAttribute("profile",new Profile());
        session.setAttribute("profile",profile.getProfileID());
        return "logIn";
    }
    /*
    @GetMapping("/alphasolutions")
    public String logOut(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "frontpage";
    }
     */


    @PostMapping("")
    public String logInPost(@ModelAttribute Profile profile){
        Profile profile1 = profileService.logIn(profile);

        if (profile1 == null){
            return "redirect:/logIn";
        }
        return "redirect:/alphasolutions";
    }

    @GetMapping("/create")
    public String registrerForm(Model model){
        model.addAttribute("profile", new Profile());
        return "registrer";
    }

    @PostMapping("/create")
    public String registrer(@ModelAttribute Profile profile){
        profileService.registrer(profile);
        return "redirect:/alphasolutions";
    }

}
