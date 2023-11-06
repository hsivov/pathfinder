package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (user == null) {
            throw new IllegalArgumentException("User with that username:" + username + " is not present");
        }

        boolean passwordMatch = passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new IllegalArgumentException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());

        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
