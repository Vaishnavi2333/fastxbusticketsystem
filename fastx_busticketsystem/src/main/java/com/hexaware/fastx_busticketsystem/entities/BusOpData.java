package com.hexaware.fastx_busticketsystem.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class BusOpData {
	
	@Id
	private int busOpdataId;
    private int busOpId;
    private String name;
    private String companyName;
    private String licenceNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String contactNumber;
    private String address;
    
    @OneToOne(mappedBy = "busopdata",cascade = CascadeType.ALL)
    private BusOpLogin busOpLogin;
    
    @OneToMany(mappedBy = "busOpData", cascade = CascadeType.ALL)
    private Set<Bus> buses = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminLogin admin;

    public BusOpData() {
       
    }
    
    
	public BusOpData(int busOpdataId, int busOpId, String name, String companyName, String licenceNumber, String gender,
			LocalDate dateOfBirth, String email, String contactNumber, String address, BusOpLogin busOpLogin) {
		super();
		this.busOpdataId = busOpdataId;
		this.busOpId = busOpId;
		this.name = name;
		this.companyName = companyName;
		this.licenceNumber = licenceNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
		this.busOpLogin = busOpLogin;
	}


	public BusOpData(int busOpdataId, int busOpId, String name, String companyName, String licenceNumber, String gender,
			LocalDate dateOfBirth, String email, String contactNumber, String address) {
		super();
		this.busOpdataId = busOpdataId;
		this.busOpId = busOpId;
		this.name = name;
		this.companyName = companyName;
		this.licenceNumber = licenceNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public int getBusOpdataId() {
		return busOpdataId;
	}
	public void setBusOpdataId(int busOpdataId) {
		this.busOpdataId = busOpdataId;
	}
	public int getBusOpId() {
		return busOpId;
	}
	public void setBusOpId(int busOpId) {
		this.busOpId = busOpId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public BusOpLogin getBusOpLogin() {
		return busOpLogin;
	}


	public void setBusOpLogin(BusOpLogin busOpLogin) {
		this.busOpLogin = busOpLogin;
	}
	
	 public Set<Bus> getBuses() {
	        return buses;
	    }

	    public void setBuses(Set<Bus> buses) {
	        this.buses = buses;
	    }
	

    public void addBus(Bus bus) {
        bus.setBusOpData(this);
        this.buses.add(bus);
    }
	
	

}
