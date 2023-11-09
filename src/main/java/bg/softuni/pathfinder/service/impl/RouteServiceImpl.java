package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper,
                            CategoryRepository categoryRepository, UserService userService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    @Override
    public void add(AddRouteDTO addRouteDTO) {
        Route route = modelMapper.map(addRouteDTO, Route.class);
        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findByNameIn(addRouteDTO.getCategories());
        route.addCategories(categories);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        routeRepository.save(route);
    }
}
