package com.bijay.lazy.fetch.service;

import com.bijay.lazy.fetch.entity.Department;

public interface DepartmentService {
    Department fetchDepartmentById(Long id);

    void createDepartment();
}
