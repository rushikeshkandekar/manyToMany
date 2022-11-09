package com.example.manytomany.mapper;

import com.example.manytomany.entity.EmployeeEntity;
import com.example.manytomany.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToModel(EmployeeEntity employeeEntity);

    EmployeeEntity modelToEntity(Employee employee);
}
