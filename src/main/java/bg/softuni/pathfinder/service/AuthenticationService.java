package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

    boolean isUniqueUsername(UserRegisterBindingModel userRegisterBindingModel);
}
