package com.lakshan.controller;

import com.lakshan.model.StdPrice;
import com.lakshan.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LakshanD on 11/26/2016.
 */

@RestController
@RequestMapping(value = "/rest/price")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StdPrice>> getAllPriceList(){
        List<StdPrice> priceList=priceRepository.findAll();
        return new ResponseEntity<List<StdPrice>>(priceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StdPrice> getPriceByProductId(@PathVariable Integer id){
        StdPrice price=priceRepository.findOne(id);
        return new ResponseEntity<StdPrice>(price,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addProductPrice(@RequestBody StdPrice price){
        if(!priceRepository.exists(price.getId())){
            priceRepository.save(price);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@RequestBody StdPrice price){
        if(priceRepository.exists(price.getId())){
            priceRepository.save(price);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        if(priceRepository.exists(id)){
            priceRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}

