package com.bijay.lazy.fetch.service;

import com.bijay.lazy.fetch.dto.response.SubDepartmentResponseDTO;
import com.bijay.lazy.fetch.entity.SubDepartment;

public interface SubDepartmentService {

    void createSubDepartment();

    SubDepartmentResponseDTO fetchSubDepartmentById(Long id);

    SubDepartmentResponseDTO fetchSubDepartmentAndDepartmentById(Long id, Boolean includeDepartment);

    Integer findSubDepartmentCountByName(String name);

}
