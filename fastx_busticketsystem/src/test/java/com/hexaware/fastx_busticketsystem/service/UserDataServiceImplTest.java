package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;

import jakarta.transaction.Transactional;


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:14-Aug-2025
Description:  UserDataService  Class test case*/

@SpringBootTest
@Transactional 
class UserDataServiceImplTest {

    @Autowired
    private UserDataServiceImpl service;

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Autowired
    private UserDataRepo userDataRepo;

    private UserLogin savedLogin;

    @BeforeEach
    void setup() {
     
        UserLogin login = new UserLogin();
        login.setUsername("suresh23");
        login.setPassword("suresh@123");
        savedLogin = userLoginRepo.save(login);
    }

    @Test
    void testCreateUser() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId()); 
        dto.setName("Suresh");
        dto.setGender("Male");
        dto.setEmail("suresh@gmail.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("Chennai Street");

        UserData created = service.createUser(dto);

        assertNotNull(created.getUserdataId());
        assertEquals("Suresh", created.getName());
        assertEquals(savedLogin.getUserId(), created.getUserLogin().getUserId());
    }

    @Test
    void testUpdateUser() throws Exception {
    
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("Suresh");
        dto.setGender("Male");
        dto.setEmail("suresh@gmail.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("Chennai Street");
        service.createUser(dto);

        dto.setName("Shayan");
        UserData updated = service.updateUser(dto);

        assertEquals("Shayan", updated.getName());
    }

    @Test
    void testGetUserById() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("Suresh");
        dto.setGender("Male");
        dto.setEmail("suresh@gmail.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("Chennai Street");
        service.createUser(dto);

        UserData fetched = service.getUserById(savedLogin.getUserId());
        assertEquals("Suresh", fetched.getName());
    }



    @Test
    void testDeleteUser() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("Suresh");
        dto.setGender("Male");
        dto.setEmail("suresh@gmail.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("Chennai Street");
        service.createUser(dto);

        String result = service.deleteUser(savedLogin.getUserId());
        assertEquals("Deleted Successfully", result);

        assertTrue(userDataRepo.findByUserLogin_UserId(savedLogin.getUserId()).isEmpty());
        assertTrue(userLoginRepo.findById(savedLogin.getUserId()).isEmpty());
    }
}
