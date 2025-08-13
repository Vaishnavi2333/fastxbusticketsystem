package com.hexaware.fastx_busticketsystem.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	private int routeId;
    private String routeName;
    private String origin;
    private String destination;
    private double distanceKm;
    private LocalTime estimatedTime;
    
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private List<Trip> trips;
    
    
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Bus> buses = new ArrayList<>();
    
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminLogin admin;
    
    public Route() {
    	
    }

	public Route(int routeId, String routeName, String origin, String destination, double distanceKm,
			LocalTime estimatedTime) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.origin = origin;
		this.destination = destination;
		this.distanceKm = distanceKm;
		this.estimatedTime = estimatedTime;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getDistanceKm() {
		return distanceKm;
	}
	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}
	public LocalTime getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(LocalTime estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
	
    

}
