package com.services;

import com.models.Rider;

import java.util.List;

public interface RiderService {
    Rider createRider(Rider rider);
    List<Rider> getRiders();
//    Rider getRider();
    Rider getRiderById(int id);
    Rider updateRider(Rider rider);
}
