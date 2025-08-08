package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BusAmenity {

    @Id
    
    private int id;  

    private String amenityName;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public BusAmenity() {
    }

    public BusAmenity(String amenityName) {
        this.amenityName = amenityName;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}

