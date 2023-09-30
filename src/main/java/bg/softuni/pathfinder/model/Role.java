package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole name;

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }
}
