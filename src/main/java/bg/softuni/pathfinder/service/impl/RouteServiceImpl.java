package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exeptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = modelMapper.map(addRouteBindingModel, Route.class);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        String regex = "v=(.*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(addRouteBindingModel.getVideoUrl());

        if (matcher.find()) {
            String url = matcher.group(1);
            route.setVideoUrl(url);
        }

        routeRepository.save(route);
    }

    @Override
    public List<RouteGetAllViewModel> getAll() {

        return routeRepository.findAll().stream()
                .map(route -> modelMapper.map(route, RouteGetAllViewModel.class))
                .toList();
    }

    @Override
    public RouteDetailsViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));

        return modelMapper.map(route, RouteDetailsViewModel.class);
    }
}
