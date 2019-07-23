package com.bijay.lazy.fetch.service.impl;

import com.bijay.lazy.fetch.repository.DepartmentRepository;
import com.bijay.lazy.fetch.entity.Department;
import com.bijay.lazy.fetch.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createDepartment(){
        Department department = new Department();
        department.setId(1L);
        department.setDepartmentName("Bijay");
        department.setCode("BJ");
        department.setCreatedById(1L);
        department.setCreatedDate(new Date());
        department.setModifiedById(null);
        department.setLastModifiedDate(null);
        department.setStatus('Y');

        Department department2 = new Department();
        department2.setId(2L);
        department2.setDepartmentName("Bijay World");
        department2.setCode("BJWW");
        department2.setCreatedById(1L);
        department2.setCreatedDate(new Date());
        department2.setModifiedById(null);
        department2.setLastModifiedDate(null);
        department2.setStatus('Y');

//        Department department2 = Department.builder()
//                .departmentName("ERP Department")
//                .code("ERP")
//                .createdById(1L)
//                .createdDate(new Date())
//                .status('Y')
//                .lastModifiedDate(null)
//                .modifiedById(null)
//                .id(2L)
//                .build();

        departmentRepository.save(department);
//        departmentRepository.save(departmentBuild);
        departmentRepository.save(department2);
    }

    @Override
    public Department fetchDepartmentById(Long id){
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        return departmentOptional.get();
    }

}
