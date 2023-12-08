package bg.softuni.pathfinder.model.dto.view;

import bg.softuni.pathfinder.model.enums.Level;

public class UserProfileViewModel {
    private String fullName;
    private String username;
    private int age;
    private Level level;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
