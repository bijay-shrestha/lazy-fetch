package com.bijay.lazy.fetch.service;

import com.bijay.lazy.fetch.dto.response.SubDepartmentResponseDTO;

public interface SubDepartmentService {

    void createSubDepartment();

    SubDepartmentResponseDTO fetchSubDepartmentById(Long id);

    SubDepartmentResponseDTO fetchSubDepartmentAndDepartmentById(Long id, Boolean includeDepartment);
}
