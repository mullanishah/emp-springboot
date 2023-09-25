package com.shah.emp.service;

import java.util.List;
import com.shah.emp.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createNewEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId) throws Exception;
	
	List<EmployeeDto> getAllEmployees() throws Exception;
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) throws Exception;
	
	void deleteEmployee(Long employeeId) throws Exception;

}
