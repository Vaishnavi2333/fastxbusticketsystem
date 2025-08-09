package com.hexaware.fastx_busticketsystem.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_login")
public class AdminLogin {
		
        @Id
        
        private int adminId;
		private String username;
		private String password;
		
		
	    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	    private List<BusOpData> managedOperators;
	    
		/*
		 * @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL) private
		 * List<UserData> managedUsers;
		 */
	    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	    private List<Route> managedRoutes;

	    
	    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	    private List<Booking> managedBookings;
	    
		public AdminLogin(int adminId, String username, String password) {
			super();
			this.adminId = adminId;
			this.username = username;
			this.password = password;
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
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
		
		public List<BusOpData> getManagedOperators() {
	        return managedOperators;
	    }

	    public void setManagedOperators(List<BusOpData> managedOperators) {
	        this.managedOperators = managedOperators;
	    }

	    public List<Route> getManagedRoutes() {
	        return managedRoutes;
	    }

	    public void setManagedRoutes(List<Route> managedRoutes) {
	        this.managedRoutes = managedRoutes;
	    }

	    public List<Booking> getManagedBookings() {
	        return managedBookings;
	    }

	    public void setManagedBookings(List<Booking> managedBookings) {
	        this.managedBookings = managedBookings;
	    }
		

	}



