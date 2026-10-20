package cat.liceu.demo.controllers;

import cat.liceu.demo.Service.PrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    PrimesService primerService;

    @GetMapping("/primes")
    public String primes(@RequestParam int n, Model model) {
        List<Integer> primes = primerService.getPrimes(n);
        model.addAttribute("primes", primes);
        return "primes";
    }

    @GetMapping("/goodbye")
    public String goodBye() {
        return "goodBye";
    }
}