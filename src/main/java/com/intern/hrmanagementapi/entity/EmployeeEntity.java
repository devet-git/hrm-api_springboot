package com.intern.hrmanagementapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class EmployeeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  @Column(name = "firstName", nullable = false)
  private String firstName;

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "gender", nullable = false)
  private int gender;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "dob", nullable = false)
//  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
//  @JsonFormat(pattern = "yyyy-MM-dd")
//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")

  private Date dob;

//  @Column(name = "departmentId", nullable = false)
//  private int departmentId;
//
//  @Column(name = "positionId", nullable = false)
//  private int positionId;
//
//  @Column(name = "contractId", nullable = false)
//  private int contractId;
//
//  @Column(name = "educationId", nullable = false)
//  private int educationId;

  private Date createDate;
  private Date updateDate;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @JsonIgnore
  private UserEntity user;
}
