package com.shah.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shah.emp.dto.EmployeeDto;
import com.shah.emp.entity.Employee;
import com.shah.emp.exception.ResourceNotFoundException;
import com.shah.emp.mapper.CommonEmpMapper;
import com.shah.emp.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
		
		Employee employeeEntity = CommonEmpMapper.mapToEntity(employeeDto);
		Employee savedEmployee = employeeRepository.save(employeeEntity);
		return CommonEmpMapper.mapToDto(savedEmployee);
	}


	@Override
	public EmployeeDto getEmployeeById(Long employeeId) throws Exception{
		Employee employee = employeeRepository.findById(employeeId)
			.orElseThrow(() -> new ResourceNotFoundException("Employee with given " + employeeId + " id does not exist!!"));
		return CommonEmpMapper.mapToDto(employee);
	}


	@Override
	public List<EmployeeDto> getAllEmployees() throws Exception {
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty())
			throw new ResourceNotFoundException("Employee details are not available!!");
		return employees.stream().map((employee) -> CommonEmpMapper.mapToDto(employee)).collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedDto) throws Exception {
		
		Employee savedEmployee = employeeRepository.findById(employeeId)
			.orElseThrow(() -> new ResourceNotFoundException("Employee with given " + employeeId + " id does not exist!!"));
		
		savedEmployee.setFirstName(updatedDto.getFirstName());
		savedEmployee.setLastName(updatedDto.getLastName());
		savedEmployee.setEmail(updatedDto.getEmail());
		Employee updatedEntity = employeeRepository.save(savedEmployee);				//save or update
		return CommonEmpMapper.mapToDto(updatedEntity);
	}


	@Override
	public void deleteEmployee(Long employeeId) throws Exception {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given " + employeeId + " id does not exist!!"));
		employeeRepository.delete(employee);
	}

}
