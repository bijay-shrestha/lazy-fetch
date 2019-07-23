package com.bijay.lazy.fetch.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubDepartmentResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String code;
    private Character status;
    private DepartmentResponseDTO departmentResponseDTO;
}
