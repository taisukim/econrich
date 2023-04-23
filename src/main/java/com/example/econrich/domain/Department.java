package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    @Column(name = "department_name", nullable = false, length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
}
