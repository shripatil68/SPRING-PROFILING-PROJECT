package com.shridhar.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shridhar.springbootwebtutorial.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeDTO {

    @NonNull
    private Long id;
    private String name;
    @Email
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
    @EmployeeRoleValidation
    private String role;

}
