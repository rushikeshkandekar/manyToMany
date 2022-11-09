package com.example.manytomany.mapper;


import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
DepartmentEntity modelToEntity (Department department);
Department entityToModel (DepartmentEntity departmentEntity);
}
