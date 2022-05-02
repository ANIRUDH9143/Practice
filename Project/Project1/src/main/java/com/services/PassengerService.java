package com.services;

import com.models.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger customer);
    List<Passenger> getPassengers();
//    Passenger getPassenger();
    Passenger getPassengerById(int id);
}
