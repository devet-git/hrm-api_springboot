package com.intern.hrmanagementapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "attendances")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID employeeId;

  @Temporal(TemporalType.DATE)
  private Date date;
  //  @Temporal(TemporalType.TIME)
  private LocalDateTime startTime;
  //  @Temporal(TemporalType.TIME)
  private LocalDateTime endTime;
  private String workingTime;
  private String note;
}
