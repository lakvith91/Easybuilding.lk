package com.lakshan.controller;

import com.lakshan.model.Category;
import com.lakshan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LakshanD on 11/6/2016.
 */
@RestController
@RequestMapping("/rest/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=repository.findAll();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
}
