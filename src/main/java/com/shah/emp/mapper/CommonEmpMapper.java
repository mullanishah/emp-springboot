package com.shah.emp.mapper;

import com.shah.emp.dto.EmployeeDto;
import com.shah.emp.entity.Employee;

public class CommonEmpMapper {
	
	public static EmployeeDto  mapToDto(Employee entity) {
		
		EmployeeDto dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		return dto;
	}
	
	public static Employee mapToEntity(EmployeeDto dto) {
		
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		return entity;
	}

}
