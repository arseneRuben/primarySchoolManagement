package com.primaryschools.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "students")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Student {
    @Id
    @UuidGenerator
    @Column(name="id", unique=true, nullable=false)
    private String id;
    private String firtName;
    private String lastName;
    private String matriculeNumber;
    private String birthPlace;
    private String gender;
    private String birthDate   ;
    private String region;
    private String city;
    private String nationality;
    private String residence;
    private String previousSchool;
    private String photoUrl;
    private String status;
}
