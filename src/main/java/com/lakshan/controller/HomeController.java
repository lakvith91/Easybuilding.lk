package com.lakshan.controller;

import com.lakshan.model.Contractor;
import com.lakshan.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseBody
    public String index(){
        return repository.findAll().get(0).getId()+"";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Contractor>> getAllContractors(){
        List<Contractor> contractors = repository.findAll();
        return new ResponseEntity<List<Contractor>>(contractors, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addContractor(@RequestBody Contractor contractor){
        repository.save(contractor);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contractor> findContractorById(@PathVariable int id){
        Contractor contractor=repository.findOne(id);
        return new ResponseEntity<Contractor>(contractor,HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContractor(@PathVariable int id){
      if(repository.exists(id)){
          repository.delete(id);
          return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
      }else{
          
      }
    }
}
