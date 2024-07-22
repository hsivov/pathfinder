package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        User user = modelMapper.map(userRegisterBindingModel, User.class);

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return userRepository.findByUsername(username) == null;
    }

    @Override
    public boolean isEmailUnique(String email) {
        return userRepository.findByEmail(email) == null;
    }

}
