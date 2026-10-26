package cat.liceu.demo.controllers;

import cat.liceu.demo.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {

        if (loginService.checkLogin(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/private";
        }
        model.addAttribute("message", "User/pass incorrect");
        return "login";
    }

    @GetMapping("/private")
    public String partPrivada(@SessionAttribute(required = false) String username) {
        if (username == null) {
            return "redirect:/login";
        }
        return "private";
    }
}