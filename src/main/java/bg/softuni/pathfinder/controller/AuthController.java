package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;
import bg.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final RouteService routeService;
    private final UserService userService;

    public AuthController(RouteService routeService, UserService userService) {
        this.routeService = routeService;
        this.userService = userService;
    }

    @GetMapping("/routes")
    public List<RouteGetAllViewModel> getRoutes() {

        return routeService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserProfileViewModel userProfile(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
