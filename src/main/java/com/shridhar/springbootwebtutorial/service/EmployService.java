package com.shridhar.springbootwebtutorial.service;

import com.shridhar.springbootwebtutorial.controllers.repository.EmployeeRepository;
import com.shridhar.springbootwebtutorial.dto.EmployeeDTO;
import com.shridhar.springbootwebtutorial.entity.EmployEntity;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EmployService {


    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public boolean deleteEmployee(Long id) {
        EmployEntity employEntity = employeeRepository.findById(id).orElse(null);
        if(employEntity == null) return false;

        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employees) {
        EmployEntity employEntity = modelMapper.map(employees, EmployEntity.class);
        EmployEntity saveEmployEntity = employeeRepository.save(employEntity);
        return modelMapper.map(saveEmployEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployee() {
        List<EmployEntity> employEntities = employeeRepository.findAll();
        return employEntities.stream().map(employEntity -> modelMapper.map(employEntity, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employee) {
        EmployEntity employEntity = modelMapper.map(employee, EmployEntity.class);
        employEntity.setId(id);
        EmployEntity savedEmployEntity = employeeRepository.save(employEntity);
        return modelMapper.map(savedEmployEntity, EmployeeDTO.class);

    }

    public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updates) {
        boolean isExist = employeeRepository.existsById(id);
        if(!isExist) return null;
        EmployEntity employEntity = employeeRepository.findById(id).orElse(null);
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(EmployEntity.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employEntity), EmployeeDTO.class);
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employEntity -> modelMapper.map(employEntity, EmployeeDTO.class));
    }
}
