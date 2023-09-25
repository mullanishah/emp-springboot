package com.shah.emp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shah.emp.dto.EmployeeDto;
import com.shah.emp.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//Build Add employee REST api
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//build Get employee REST api
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) throws Exception{
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build get All employees REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()throws Exception {
		List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(employeeDtoList, HttpStatus.OK);
	}
	
	//Build a REST API for updating employee details
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId, 
													  @RequestBody EmployeeDto empDto) throws Exception{
		EmployeeDto employeeDto = employeeService.updateEmployee(empId, empDto);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}
	
	//Build a REST API for deleting an employee
	@DeleteMapping
	public ResponseEntity<String> deleteEmployee(@RequestParam(name="id") long empId) throws Exception{
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok("Employee deleted successfully!");
	}
	
}
