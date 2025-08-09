package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="busop_login")
public class BusOpLogin {
	
    @Id
	private int busOpId;
	private String username;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "busopdata_id")
	private BusOpData busopdata;
	
	public BusOpLogin() {
		
	}

	public BusOpLogin(int busOpId, String username, String password) {
		super();
		this.busOpId = busOpId;
		this.username = username;
		this.password = password;
	}
	
	public BusOpLogin(int busOpId, String username, String password, BusOpData busopdata) {
		super();
		this.busOpId = busOpId;
		this.username = username;
		this.password = password;
		this.busopdata = busopdata;
	}
	public int getBusOpId() {
		return busOpId;
	}
	public void setBusOpId(int busOpId) {
		this.busOpId = busOpId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public BusOpData getBusopdata() {
		return busopdata;
	}

	public void setBusopdata(BusOpData busopdata) {
		this.busopdata = busopdata;
	}
	
	

}
