package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @SequenceGenerator(name = "seq_dept_id", initialValue = 1, sequenceName = "seq_dept_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dept_id")
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "departments")
    private Set<EmployeeEntity> employees;
}
