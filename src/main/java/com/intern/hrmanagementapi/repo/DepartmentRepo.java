package com.intern.hrmanagementapi.repo;

import com.intern.hrmanagementapi.entity.DepartmentEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, UUID> {

}
