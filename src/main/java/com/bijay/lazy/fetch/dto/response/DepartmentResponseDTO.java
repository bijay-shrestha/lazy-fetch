package com.bijay.lazy.fetch.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DepartmentResponseDTO implements Serializable {
    private Long id;
    private String departmentName;
    private String code;
    private Character status;
    private Date createdDate;
    private Date lastModifiedDate;
    private Long createdById;
    private Long modifiedById;

}
