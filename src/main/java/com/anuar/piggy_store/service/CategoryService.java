package com.anuar.piggy_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.anuar.piggy_store.domain.Category;
import com.anuar.piggy_store.dto.response.CategoryDtoRes;
import com.anuar.piggy_store.dto.response.ProductDtoRes;
import com.anuar.piggy_store.repository.CategoryRepository;


@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository=repository;
    }

    public List<CategoryDtoRes> getByPage(Pageable pageable){
        
        return repository.findByPage(pageable);
    }

    public Optional<Category> getByID(Long id){
        return repository.findById(id);
    }

    public Boolean save(Category category){
        if (category.getName()==null) {

            return false;
        }
        repository.save(category);
        return true;
    } 

    public List<Category> saveAll(List<Category> categories){
        return repository.saveAll(categories);
    }

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Optional<Category> getByName(String name){
        return repository.findByName(name);
    }

    public List<ProductDtoRes> getByCategoryWithProducts(String category){
        return repository.findByCategoryWithProducts(category);
    }

}