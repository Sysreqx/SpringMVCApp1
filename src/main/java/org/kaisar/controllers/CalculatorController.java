package org.kaisar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) String a,
                                 @RequestParam(value = "b", required = false) String b,
                                 @RequestParam(value = "c", required = false) String c,
                                 Model model) {
        int n = 0;
        String s;
        if (Objects.equals(c, "add")) {
            n = Integer.parseInt(a) + Integer.parseInt(b);
            s = String.valueOf(n);
            model.addAttribute("message", a + " + " + b + " = " + s);
        }
        else if (Objects.equals(c, "subtract")) {
            n = Integer.parseInt(a) - Integer.parseInt(b);
            s = String.valueOf(n);
            model.addAttribute("message", a + " - " + b + " = " + s);
        }
        else if (Objects.equals(c, "multiply")) {
            n = Integer.parseInt(a) * Integer.parseInt(b);
            s = String.valueOf(n);
            model.addAttribute("message", a + " * " + b + " = " + s);
        }
        else if (Objects.equals(c, "divide")) {
            n = Integer.parseInt(a) / Integer.parseInt(b);
            s = String.valueOf(n);
            model.addAttribute("message", a + " / " + b + " = " + s);
        }
        else {
            model.addAttribute("message", a + " " + b + " " + c);
        }

        return "calculator/calculator";
    }
}
