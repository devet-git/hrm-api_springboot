package com.intern.hrmanagementapi.repo;

import com.intern.hrmanagementapi.entity.AttendanceEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceEntity, UUID> {

  Optional<AttendanceEntity> findByIdAndEmployeeId(UUID id, UUID employeeId);
}
