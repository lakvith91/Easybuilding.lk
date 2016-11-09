package com.lakshan.controller;

import com.lakshan.model.Contractor;
import com.lakshan.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LakshanD on 10/31/2016.
 */

@RestController
@RequestMapping(value = "/rest/contractor")
public class HomeController {

    @Autowired
    private ContractorRepository repository;

    @RequestMapping("/home")
    public String index() {
       // return repository.findAll().get(0).getId() + "";
        return "index";
    }

    //return all the contractor list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Contractor>> getAllContractors() {
        List<Contractor> contractors = repository.findAll();
        return new ResponseEntity<List<Contractor>>(contractors, HttpStatus.OK);
    }

    //add new contractor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addContractor(@RequestBody Contractor contractor) {
        if (!repository.exists(contractor.getId())) {
            repository.save(contractor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    //find contractor by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contractor> findContractorById(@PathVariable int id) {
        Contractor contractor = repository.findOne(id);
        return new ResponseEntity<Contractor>(contractor, HttpStatus.OK);
    }

    //delete contractor by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContractor(@PathVariable int id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    //update contractor
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateContractor(@RequestBody Contractor contractor) {
        if (repository.exists(contractor.getId())) {
            repository.save(contractor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
