package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "bus_op_login")
public class BusOpLogin {

    @Id
    @Column(name = "bus_op_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int busOpId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "busopdata_id", referencedColumnName = "bus_opdata_id") 
    private BusOpData busOpData;
    public BusOpLogin() {
    }

    public BusOpLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BusOpLogin(String username, String password, BusOpData busOpdata) {
        this.username = username;
        this.password = password;
        this.busOpData = busOpdata;
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
        return busOpData;
    }

    public void setBusopdata(BusOpData busopdata) {
        this.busOpData = busopdata;
    }
}

	


