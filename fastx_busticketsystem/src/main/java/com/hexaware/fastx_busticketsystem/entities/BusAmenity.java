package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_amenity")
public class BusAmenity {

    @Id
    private int busamenityId; 
    
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

   private String amenityName;
    public BusAmenity() {}
	public BusAmenity(int busamenityId, Bus bus, String amenityName) {
		super();
		this.busamenityId = busamenityId;
		this.bus = bus;
		this.amenityName = amenityName;
	}
	public int getBusamenityId() {
		return busamenityId;
	}
	public void setBusamenityId(int busamenityId) {
		this.busamenityId = busamenityId;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public String getAmenityName() {
		return amenityName;
	}
	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}
	

   
}
