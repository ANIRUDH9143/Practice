package com.controllers;

import com.models.Rider;
import com.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class RiderController {

    @Autowired
    @Qualifier("database")
    private RiderService riderService;


    public RiderController() {
    }

    @RequestMapping("/getRiders")
    public List<Rider> getRiders(){
        return riderService.getRiders();
    }

    @RequestMapping("/getRiderById/{id}")
    public Rider getRiderById(@PathVariable("id") int id){
        return riderService.getRiderById(id);
    }


    @PostMapping("/postRider")
    public Rider createRider(@RequestBody Rider rider){
        System.out.println(rider);
        return riderService.createRider(rider);
    }

    @PutMapping(value = "/updateRider")
    public Rider updateRider(@RequestBody  Rider rider){
        System.out.println("==="+rider);
        return riderService.updateRider(rider);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String myMethod() {
//        return "index";
//    }
}


