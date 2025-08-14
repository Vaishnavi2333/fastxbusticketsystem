package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusOpDataDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusOpDataRepo;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;

@SpringBootTest
class BusOpDataServiceImplTest {

    @Autowired
    private BusOpDataServiceImpl service;

    @Autowired
    private BusOpDataRepo repo;

    @Autowired
    private BusOpLoginRepo busOpLoginRepo;

    private BusOpLogin savedLogin;

    @BeforeAll
    void setup() {
       
        BusOpLogin login = new BusOpLogin();
        login.setUsername("operator1");
        login.setPassword("password123");
       
        savedLogin = busOpLoginRepo.save(login);
    }

    @Test
    void testAddOperatorData() throws BusOperatorNotFoundException {
        BusOpDataDto dto = new BusOpDataDto();
        dto.setBusOpLoginId(savedLogin.getBusOpId());
        dto.setName("John Doe");
        dto.setGender("Male");
        dto.setCompanyName("FastX");
        dto.setLicenceNumber("LIC123");
        dto.setEmail("john@example.com");
        dto.setContactNumber("9876543210");
        dto.setDateOfBirth(LocalDate.of(1990, 1, 1));
        dto.setAddress("123 Street, City");

        BusOpData saved = service.addOperatorData(dto);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getName());
        assertEquals(savedLogin.getBusOpId(), saved.getBusOpLogin().getBusOpId());
    }

    @Test
    void testGetAllOperators() throws BusOperatorNotFoundException {
        List<BusOpData> operators = service.getAllOperators();
        assertNotNull(operators);
        
    }

    @Test
    void testUpdateOperatorData() throws BusOperatorNotFoundException {
        BusOpDataDto dto = new BusOpDataDto();
        dto.setBusOpdataId(repo.findAll().get(0).getBusOpdataId());
        dto.setName("Updated Name");
        dto.setGender("Female");
        dto.setCompanyName("Updated Co");
        dto.setLicenceNumber("NEWLIC");
        dto.setEmail("updated@example.com");
        dto.setContactNumber("1234567890");
        dto.setDateOfBirth(LocalDate.of(1995, 5, 5));
        dto.setAddress("Updated Address");

        BusOpData updated = service.updateOperatorData(dto);
        assertEquals("Updated Name", updated.getName());
        assertEquals("Female", updated.getGender());
    }

    @Test
    void testGetOperatorDataById() throws BusOperatorNotFoundException {
        int id = repo.findAll().get(0).getBusOpdataId();
        BusOpData op = service.getOperatorDataById(id);
        assertNotNull(op);
        assertEquals(id, op.getBusOpdataId());
    }

    @Test
    void testDeleteOperatorData() throws BusOperatorNotFoundException {
        int id = repo.findAll().get(0).getBusOpdataId();
        String msg = service.deleteOperatorData(id);
        assertEquals("Operator with id " + id + " deleted successfully.", msg);
      
    }
}