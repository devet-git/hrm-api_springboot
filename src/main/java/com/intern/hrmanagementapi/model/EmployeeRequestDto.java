package com.intern.hrmanagementapi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeRequestDto {


  @NotNull(message = "EmployeeEntity firstName is required.")
  @NotEmpty(message = "EmployeeEntity firstName is not empty or blank.")
  private String firstName;

  @NotNull(message = "EmployeeEntity lastName is required.")
  @NotEmpty(message = "EmployeeEntity lastName is not empty or blank.")
  private String lastName;

  @NotNull(message = "EmployeeEntity gender is required.")
  private int gender;

  @NotNull(message = "EmployeeEntity address is required.")
  @NotEmpty(message = "EmployeeEntity address is not empty or blank.")
  private String address;

  @NotNull(message = "EmployeeEntity date of birth is required.")
//  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//  @DateTimeFormat(pattern = "dd/MM/yyyy")
//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")

  private String dob;

//  @NotNull(message = "EmployeeEntity departmentId is required.")
//  private int departmentId;
//
//  @NotNull(message = "EmployeeEntity positionId is required.")
//  private int positionId;
//
//  @NotNull(message = "EmployeeEntity contractId is required.")
//  private int contractId;
//
//  @NotNull(message = "EmployeeEntity educationId is required.")
//  private int educationId;
}
