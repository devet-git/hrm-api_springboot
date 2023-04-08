package com.intern.hrmanagementapi.controller;

import com.intern.hrmanagementapi.constant.EndpointConst;
import com.intern.hrmanagementapi.constant.MessageConst;
import com.intern.hrmanagementapi.entity.Employee;
import com.intern.hrmanagementapi.exception.EmployeeNotFoundException;
import com.intern.hrmanagementapi.model.DataResponseDto;
import com.intern.hrmanagementapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(value = {EndpointConst.EMPLOYEE_BASE_PATH})
@CrossOrigin(maxAge = 3600)
@Tag(name = "Employee", description = "The employee API")

public class EmployeeController {

  @Autowired
  private EmployeeService service;

  @Operation(summary = "Add employee", security = {@SecurityRequirement(name = "bearer-key")})
  @PostMapping
  public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {

    employee.setCreateDate(LocalDateTime.now());
    employee.setUpdateDate(LocalDateTime.now());

    var response = service.saveEmployee(employee);
    return ResponseEntity.ok(
        DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));
  }


  @Operation(summary = "Add list employee", security = {@SecurityRequirement(name = "bearer-key")})

  @PostMapping(value = {EndpointConst.EMPLOYEE_LIST})
  public ResponseEntity<?> addEmployees(@Valid @RequestBody List<Employee> employees) {
    var response = service.saveEmployees(employees);
    return ResponseEntity.ok(
        DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));

  }

//    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
//    @GetMapping()
//    public ResponseEntity<?> getEmployees(@RequestParam(required = false) String orderBy,
//                                          @RequestParam(required = false) String name,
//                                          @RequestParam int pageNumber,
//                                          @RequestParam int pageSize) {
//        if (name != null) {
//            var response = service.getEmployeeByName(name, pageNumber, pageSize);
//            return ResponseEntity.ok(
//                    DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));
//        } else {
//            var response = service.getEmployeesByPageAndSort(orderBy, pageNumber, pageSize);
//            return ResponseEntity.ok(
//                    DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));
//        }
//    }

  @Operation(summary = "Get employee by id", security = {@SecurityRequirement(name = "bearer-key")})
  @GetMapping("/id")
  public ResponseEntity<?> findEmployeeById(@PathVariable UUID id) {
    var response = service.getEmployeeById(id);
    return ResponseEntity.ok(
        DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));
  }

  @Operation(summary = "Update employee by id", security = {
      @SecurityRequirement(name = "bearer-key")})
  @PutMapping()
  public ResponseEntity<?> updateEmployee(@RequestParam UUID id, @RequestBody Employee employee) {
    employee.setId(id);
    var response = service.updateEmployee(employee);
    return ResponseEntity.ok(
        DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, response));
  }

  @Operation(summary = "Delete employee by id", security = {
      @SecurityRequirement(name = "bearer-key")})
  @DeleteMapping()
  public ResponseEntity<?> deleteEmployee(@RequestParam UUID id) {
    try {
      service.deleteEmployee(id);
      return ResponseEntity.ok(
          DataResponseDto.success(HttpStatus.OK.value(), MessageConst.SUCCESS, "success"));
    } catch (EmployeeNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
          DataResponseDto.error(HttpStatus.NOT_FOUND.value(), MessageConst.Employee.NOT_EXIST,
              ex.getMessage()));
    }
  }

//    @PostMapping("/search")
//    public Page<Employee> search(@RequestBody SearchRequest request) {
//        return service.searchOperatingSystem(request);
//    }
}