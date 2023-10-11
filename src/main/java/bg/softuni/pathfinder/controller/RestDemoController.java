package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.RestDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestDemoController {

    private final RestDemoService restDemoService;

    public RestDemoController(RestDemoService restDemoService) {
        this.restDemoService = restDemoService;
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return restDemoService.getAll();
    }
}
