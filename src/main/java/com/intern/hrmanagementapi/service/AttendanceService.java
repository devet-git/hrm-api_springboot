package com.intern.hrmanagementapi.service;

import com.intern.hrmanagementapi.constant.MessageConst;
import com.intern.hrmanagementapi.entity.AttendanceEntity;
import com.intern.hrmanagementapi.entity.EmployeeEntity;
import com.intern.hrmanagementapi.entity.UserEntity;
import com.intern.hrmanagementapi.exception.ObjectException;
import com.intern.hrmanagementapi.model.AttendanceRequestDto;
import com.intern.hrmanagementapi.model.DataResponseDto;
import com.intern.hrmanagementapi.repo.AttendanceRepo;
import com.intern.hrmanagementapi.repo.EmployeeRepo;
import com.intern.hrmanagementapi.repo.UserRepo;
import com.intern.hrmanagementapi.util.DateTimeUtil;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceService {

  @Autowired
  private final AttendanceRepo attendanceRepo;
  @Autowired
  private final UserRepo userRepo;
  @Autowired
  private final EmployeeRepo employeeRepo;

  public DataResponseDto add(AttendanceRequestDto req) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserEntity loggingUser = userRepo.findByEmail(auth.getName()).orElseThrow(
        () -> new ObjectException(MessageConst.User.NOT_EXIST, HttpStatus.BAD_REQUEST, null));
    EmployeeEntity employeeAsUser = employeeRepo.findByEmail(loggingUser.getEmail()).orElseThrow(
        () -> new ObjectException(MessageConst.Attendance.ADD_FAILED, HttpStatus.BAD_REQUEST,
            null));

    AttendanceEntity newAttendance = AttendanceEntity.builder().employeeId(employeeAsUser.getId())
        .date(new Date()).startTime(LocalDateTime.now()).note(req.getNote()).build();
    attendanceRepo.save(newAttendance);

    return DataResponseDto.success(HttpStatus.OK.value(), HttpStatus.OK.name(), newAttendance);
  }

  public DataResponseDto updateById(UUID id, AttendanceRequestDto req) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserEntity loggingUser = userRepo.findByEmail(auth.getName()).orElseThrow(
        () -> new ObjectException(MessageConst.User.NOT_EXIST, HttpStatus.BAD_REQUEST, null));
    EmployeeEntity employeeAsUser = employeeRepo.findByEmail(loggingUser.getEmail()).orElseThrow(
        () -> new ObjectException(MessageConst.Attendance.ADD_FAILED, HttpStatus.BAD_REQUEST,
            null));

    AttendanceEntity updatedAttendance = attendanceRepo.findByIdAndEmployeeId(id,
        employeeAsUser.getId()).orElseThrow(
        () -> new ObjectException("Cannot find attendance for this user", HttpStatus.BAD_REQUEST,
            null));
    LocalDateTime endDateTime = LocalDateTime.now();
    LocalDateTime startTime = updatedAttendance.getStartTime();
    Duration workingTime = Duration.between(startTime, endDateTime);

    updatedAttendance.setEndTime(endDateTime);
    updatedAttendance.setNote(req.getNote());
    updatedAttendance.setWorkingTime(DateTimeUtil.minuteToTimeString(workingTime.toMinutes()));

    attendanceRepo.save(updatedAttendance);

    return DataResponseDto.success(HttpStatus.OK.value(), HttpStatus.OK.name(), updatedAttendance);
  }
}
