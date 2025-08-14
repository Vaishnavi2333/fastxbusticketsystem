package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.*;




/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:07-Aug-2025
Description:Busamenity Entity Class*/


@Entity
@Table(name = "bus_amenity")
public class BusAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busamenityId; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    private String amenityName;
   

    public BusAmenity() {}

    public BusAmenity(Bus bus, String amenityName) {
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
