package com.lakshan.controller;

import com.lakshan.model.Advertisement;
import com.lakshan.repository.AdvertisementRepository;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LakshanD on 11/25/2016.
 */

@RestController
@RequestMapping("/rest/ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Advertisement>> getAllAdvertisements(){
        List<Advertisement> advertisements=advertisementRepository.findAll();
        return new ResponseEntity<List<Advertisement>>(advertisements, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Advertisement> getAdsById(@PathVariable Integer id){
        Advertisement advertisement=advertisementRepository.findOne(id);
        return new ResponseEntity<Advertisement>(advertisement,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAds(@PathVariable Integer id){
        if(advertisementRepository.exists(id)){
            advertisementRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Advertisement advertisement){
        if(!advertisementRepository.exists(advertisement.getId())){
            advertisementRepository.save(advertisement);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@RequestBody Advertisement advertisement){
        if(advertisementRepository.exists(advertisement.getId())){
            advertisementRepository.save(advertisement);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }


}
