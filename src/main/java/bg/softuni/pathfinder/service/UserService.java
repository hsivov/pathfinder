package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserProfileViewModel;

public interface UserService {
    User getLoggedUser();

    UserProfileViewModel getUserProfile();
}
