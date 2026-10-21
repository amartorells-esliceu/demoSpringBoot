package cat.liceu.demo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Random;

@Controller
public class GuessNumberController {

    @GetMapping("/guess")
    public String guess(HttpSession session) {
        int target = new Random().nextInt(100) + 1;
        session.setAttribute("target", target);
        return "guess";
    }

    @PostMapping("/guess")
    public String guess2(Model model, @RequestParam int number, @SessionAttribute int target) {
        String message = "";

        if (number < target) {
            message = "El número buscat és més gran.";
        } else if (number > target) {
            message = "El número buscat és més petit.";
        } else {
            message = "Felicitats! Has encertat el número!";
        }

        model.addAttribute("message", message);
        return "guess";
    }
}