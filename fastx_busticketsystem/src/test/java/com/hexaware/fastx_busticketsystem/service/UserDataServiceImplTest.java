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
        login.setUsername("testuser");
        login.setPassword("password123");
        savedLogin = userLoginRepo.save(login);
    }

    @Test
    void testCreateUser() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId()); // matches login id
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setEmail("john@example.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("123 Main Street");

        UserData created = service.createUser(dto);

        assertNotNull(created.getUserdataId());
        assertEquals("John Doe", created.getName());
        assertEquals(savedLogin.getUserId(), created.getUserLogin().getUserId());
    }

    @Test
    void testUpdateUser() throws Exception {
        // First create a user
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setEmail("john@example.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("123 Main Street");
        service.createUser(dto);

        // Update
        dto.setName("Updated Name");
        UserData updated = service.updateUser(dto);

        assertEquals("Updated Name", updated.getName());
    }

    @Test
    void testGetUserById() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setEmail("john@example.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("123 Main Street");
        service.createUser(dto);

        UserData fetched = service.getUserById(savedLogin.getUserId());
        assertEquals("John Doe", fetched.getName());
    }

    @Test
    void testGetAllUsers() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setEmail("john@example.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("123 Main Street");
        service.createUser(dto);

        List<UserData> allUsers = service.getAllUsers();
        assertFalse(allUsers.isEmpty());
    }

    @Test
    void testDeleteUser() throws Exception {
        UserDataDto dto = new UserDataDto();
        dto.setUserdataId(savedLogin.getUserId());
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setEmail("john@example.com");
        dto.setDateOfBirth(LocalDate.of(1990, 5, 15));
        dto.setContactNumber("9876543210");
        dto.setAddress("123 Main Street");
        service.createUser(dto);

        String result = service.deleteUser(savedLogin.getUserId());
        assertEquals("Deleted Successfully", result);

        assertTrue(userDataRepo.findByUserLogin_UserId(savedLogin.getUserId()).isEmpty());
        assertTrue(userLoginRepo.findById(savedLogin.getUserId()).isEmpty());
    }
}
