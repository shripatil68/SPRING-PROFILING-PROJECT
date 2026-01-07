package com.shridhar.springbootwebtutorial.controllers;

import com.shridhar.springbootwebtutorial.dto.EmployeeDTO;
import com.shridhar.springbootwebtutorial.service.EmployService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployService employService;


    @GetMapping(path = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployee() {
        return ResponseEntity.ok(employService.getEmployee());
    }

    @GetMapping(path = "getEmployeeById/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeDTO> employeeDTO =  employService.getEmployeeById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(Optional.of(employeeDTO1))).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));
    }

    @PostMapping(path = "employees")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employees) {
        return new ResponseEntity<>(employService.addEmployee(employees), HttpStatus.OK);
    }

    @DeleteMapping(path = "employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employService.deleteEmployee(id));
    }

    @PutMapping(path = "employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee){
        return ResponseEntity.ok(employService.updateEmployee(id, employee));
    }

    @PatchMapping(path = "employees/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(employService.updatePartialEmployee(id, updates));
    }

}
