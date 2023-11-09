package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser, UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
}
