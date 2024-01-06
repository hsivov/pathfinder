package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.enums.CategoryName;
import bg.softuni.pathfinder.model.enums.Level;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class AddRouteBindingModel {
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;
    private Level level;
    private String videoUrl;
    private Set<CategoryName> categories;
    private User author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoryName> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryName> categories) {
        this.categories = categories;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
