package com.hexaware.fastx_busticketsystem.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus {

    @Id
    private int busId;

    private String busNumber;
    private String busName;
    private String busType;
    private int capacity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "busopdata_id")  
    private BusOpData busOpData;
    
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<BusAmenity> amenities = new ArrayList<>();
    
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public Bus() {
    	
    	
     
    }

    public Bus(int busId, String busNumber, String busName, String busType, int capacity, String status) {
        super();
        this.busId = busId;
        this.busNumber = busNumber;
        this.busName = busName;
        this.busType = busType;
        this.capacity = capacity;
        this.status = status;
    }

  
    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BusOpData getBusOpData() {
        return busOpData;
    }

    public void setBusOpData(BusOpData busOpData) {
        this.busOpData = busOpData;
    }
    
    public void addBusAmenity(BusAmenity busAmenity) {
        amenities.add(busAmenity);
        busAmenity.setBus(this); 
    }
    
    public void removeBusAmenity(BusAmenity busAmenity) {
        amenities.remove(busAmenity);
        busAmenity.setBus(null); 
    }
    
    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}

