package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return userService.getAll();
    }
}
