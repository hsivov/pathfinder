package bg.softuni.pathfinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class AdminController {

    @GetMapping("/admin")
    public ModelAndView adminPanel(){
        return new ModelAndView("");
    }
}
