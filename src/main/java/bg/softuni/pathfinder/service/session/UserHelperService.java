package bg.softuni.pathfinder.service.session;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserHelperService {

    private static final String ROLE_PREFIX = "ROLE_";
    private final UserRepository userRepository;

    public UserHelperService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Optional<User> getCurrentUser() {
        return userRepository.findByUsername(getUserDetails().getUsername());
    }

    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }

    public boolean hasRole(String role) {
        return getAuthentication().getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().startsWith(ROLE_PREFIX + role));
    }

    public boolean isAuthenticated() {
        return !hasRole("ANONYMOUS");
    }
}
