package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.enums.CategoryName;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getAllByNameIn(Set<CategoryName> categoryNames) {
        return categoryRepository.getAllByNameIn(categoryNames);
    }
}
