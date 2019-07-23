package com.bijay.lazy.fetch.controller;

import com.bijay.lazy.fetch.dto.response.SubDepartmentResponseDTO;
import com.bijay.lazy.fetch.service.SubDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubDepartmentController {

    private final SubDepartmentService subDepartmentService;

    public SubDepartmentController(SubDepartmentService subDepartmentService) {
        this.subDepartmentService = subDepartmentService;
    }

    @GetMapping("/sub")
    public ResponseEntity<?> fetchSubDepartments(){
        SubDepartmentResponseDTO subDepartment = subDepartmentService.fetchSubDepartmentById(1L);
        return ResponseEntity.ok(subDepartment);
    }

    @GetMapping("/sub/{id}")
    public ResponseEntity<SubDepartmentResponseDTO>
    getDepartment(@PathVariable Long id,
                  @RequestParam (required = false, defaultValue = "false") boolean includeDepartment) {
        return ResponseEntity.ok(subDepartmentService.fetchSubDepartmentAndDepartmentById(id, includeDepartment));
    }
}
