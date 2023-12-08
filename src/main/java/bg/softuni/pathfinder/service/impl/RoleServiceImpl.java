package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName (String name) {

        return this.roleRepository.findByName(UserRole.valueOf(name));
    }
}
