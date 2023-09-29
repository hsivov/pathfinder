package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType name;

    public UserType getName() {
        return name;
    }

    public void setName(UserType name) {
        this.name = name;
    }
}
