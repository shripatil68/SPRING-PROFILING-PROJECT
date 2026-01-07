package com.shridhar.springbootwebtutorial.controllers.repository;

import com.shridhar.springbootwebtutorial.entity.EmployEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployEntity, Long> {

}
