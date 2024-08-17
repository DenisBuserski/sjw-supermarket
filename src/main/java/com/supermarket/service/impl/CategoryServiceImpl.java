package com.supermarket.service.impl;

import com.supermarket.ExceptionHandlerUtil;
import com.supermarket.model.Category;
import com.supermarket.repository.CategoryRepository;
import com.supermarket.service.CategoryService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Valid
    public void addCategory(String categoryName) {
        if (this.categoryRepository.findByName(categoryName).isPresent()) {
            log.info("Category with name " + categoryName + " already exists!");
        } else {
            try {
                Category category = new Category(categoryName);
                this.categoryRepository.save(category);
                log.info("Successfully created category with name " + category.getName());
            } catch (ConstraintViolationException e) {
                ExceptionHandlerUtil.handleConstraintViolationException(e);
            }
        }

    }
}
