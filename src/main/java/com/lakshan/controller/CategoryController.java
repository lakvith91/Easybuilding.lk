package com.lakshan.controller;

import com.lakshan.model.Category;
import com.lakshan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LakshanD on 11/6/2016.
 */
@RestController
@RequestMapping("/rest/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=repository.findAll();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category=repository.findOne(id);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category){
        if(!repository.exists(category.getId())){
            repository.save(category);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@RequestBody Category category){
        if(repository.exists(category.getId())){
            repository.save(category);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        if(repository.exists(id)){
            repository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
