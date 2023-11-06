package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
