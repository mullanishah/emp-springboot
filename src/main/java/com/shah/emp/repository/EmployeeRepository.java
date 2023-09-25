package com.shah.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shah.emp.entity.Employee;

//JpaRepository interface provides various readily available CRUD methods
//JpaRepositoy interface has an implementation class that provides all CRUD methods implementation, ie. SimpleJpaRepository
//@Repository not required in this since impl class has already provided it
//@Transactional annotation also not required in service layer since impl class has already provided it
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
