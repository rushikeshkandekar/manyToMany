package com.example.manytomany.service;

import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.mapper.DepartmentMapper;
import com.example.manytomany.model.Department;
import com.example.manytomany.model.DepartmentResponse;
import com.example.manytomany.repository.DepartmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentResponse createDepartment(Department department) {
        DepartmentEntity departmentEntity = null;
        departmentEntity = departmentMapper.modelToEntity(department);
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(departmentEntity.getId());
        log.info("created successfull with id {}",departmentResponse);
        return departmentResponse;
    }

    public Department getByDepartmentId(Long id) {
        Optional<DepartmentEntity>departmentEntityOptional=departmentRepository.findById(id);
        Department department= new Department();
        if (departmentEntityOptional.isPresent()){
            department=departmentMapper.entityToModel(departmentEntityOptional.get());
            log.info("department found with id {}",id);
        }
        else {
            log.info("department id {} not found",id);
        }
        return department;
    }

    public void deleteByDepartmentId(Long id) {
        Optional<DepartmentEntity>departmentEntityOptional=departmentRepository.findById(id);
        if (departmentEntityOptional.isPresent()){
            departmentRepository.deleteById(id);
            log.info("id {} deleted successfull",id);
        }
        else{
            log.info("id {} not found",id);
        }
    }
}
