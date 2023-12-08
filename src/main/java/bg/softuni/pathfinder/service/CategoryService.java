package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.enums.CategoryName;

import java.util.Set;

public interface CategoryService {

    Set<Category> getAllByNameIn (Set<CategoryName> categoryNames);
}
