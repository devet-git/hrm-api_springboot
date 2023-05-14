package com.intern.hrmanagementapi.controller;

import com.intern.hrmanagementapi.constant.EndpointConst;
import com.intern.hrmanagementapi.model.AttendanceRequestDto;
import com.intern.hrmanagementapi.model.DataResponseDto;
import com.intern.hrmanagementapi.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {EndpointConst.Attendance.BASE_PATH})
@CrossOrigin(maxAge = 3600)
@Tag(name = "Attendance", description = "The attendance API")
public class AttendanceController {

  @Autowired
  private final AttendanceService attendanceService;

  @Operation(summary = "Add attendance", security = {
      @SecurityRequirement(name = "bearer-key")}, responses = {
      @ApiResponse(responseCode = "200", description = "Successful", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = DataResponseDto.class))}),
      @ApiResponse(responseCode = "400", description = "Bad request", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = DataResponseDto.class))}),})
  @PostMapping
  public ResponseEntity<?> addAttendance(@Valid @RequestBody AttendanceRequestDto req) {
    var res = attendanceService.add(req);
    return ResponseEntity.ok(res);
  }

  @Operation(summary = "Update attendance", security = {
      @SecurityRequirement(name = "bearer-key")}, responses = {
      @ApiResponse(responseCode = "200", description = "Successful", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = DataResponseDto.class))}),
      @ApiResponse(responseCode = "400", description = "Bad request", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = DataResponseDto.class))}),})
  @PutMapping("{id}")
  public ResponseEntity<?> update(@PathVariable("id") UUID id,
      @Valid @RequestBody AttendanceRequestDto req) {
    var res = attendanceService.updateById(id, req);
    return ResponseEntity.ok(res);
  }


}
