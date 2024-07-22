package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exeptions.UserNotFoundException;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.UserHelperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserHelperService userHelperService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserHelperService userHelperService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userHelperService = userHelperService;
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        Optional<User> optionalUser = userHelperService.getCurrentUser();

        return optionalUser.map(user -> modelMapper.map(user, UserProfileViewModel.class)).orElse(null);

    }

    @Override
    public UserProfileViewModel getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        return modelMapper.map(user, UserProfileViewModel.class);
    }
}
