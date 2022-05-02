package com.controllers;

import com.models.Passenger;
import com.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class PassengerController {

    @Autowired
    @Qualifier("database2")
    private PassengerService passengerService;

//    @Autowired
//    @Qualifier("database3")
//    private PickService pickedService;
    public PassengerController() {
    }

    @RequestMapping("/getPassengers")
    public List<Passenger> getPassengers(){
        return passengerService.getPassengers();
    }


    @RequestMapping("/getPassengerById/{id}")
    public Passenger getPassengerById(@PathVariable("id") int id){
        return passengerService.getPassengerById(id);
    }

    @PostMapping("/postPassenger")
    public Passenger postPassenger(@RequestBody Passenger passenger){
        System.out.println(passenger);
        return passengerService.createPassenger(passenger);
    }

}


