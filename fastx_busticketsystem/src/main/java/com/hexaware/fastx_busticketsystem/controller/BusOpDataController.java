package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BusOpDataDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBusOpDataService;





@RestController
@RequestMapping("/busopdata")
public class BusOpDataController {
	
	@Autowired
	IBusOpDataService service;
	
	 @PostMapping("/add")
	    public BusOpData addOperator(@RequestBody BusOpDataDto dto) {
	        return service.addOperatorData(dto);
	    }

	    @PutMapping("/update")
	    public BusOpData updateOperator(@RequestBody BusOpDataDto dto) throws BusOperatorNotFoundException {
	        return service.updateOperatorData(dto);
	    }

	    @GetMapping("/getbyid/{operatorId}")
	    public BusOpData getOperatorById(@PathVariable int operatorId) throws BusOperatorNotFoundException {
	        return service.getOperatorDataById(operatorId);
	    }

	    @GetMapping("/getall")
	    public List<BusOpData> getAllOperators() {
	        return service.getAllOperators();
	    }

	    @DeleteMapping("/delete/{operatorId}")
	    public String deleteOperator(@PathVariable int operatorId) throws BusOperatorNotFoundException {
	        return service.deleteOperatorData(operatorId);
	    }

}
