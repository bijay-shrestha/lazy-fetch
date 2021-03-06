package com.bijay.lazy.fetch.service.impl;

import com.bijay.lazy.fetch.dto.response.DepartmentResponseDTO;
import com.bijay.lazy.fetch.service.DepartmentService;
import com.bijay.lazy.fetch.dto.response.SubDepartmentResponseDTO;
import com.bijay.lazy.fetch.entity.SubDepartment;
import com.bijay.lazy.fetch.repository.SubDepartmentRepository;
import com.bijay.lazy.fetch.service.SubDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Transactional
public class SubDepartmentServiceImpl implements SubDepartmentService {

    private ModelMapper modelMapper;
    private final DepartmentService departmentService;
    private final SubDepartmentRepository subDepartmentRepository;
    private EntityManager entityManager;

    public SubDepartmentServiceImpl(ModelMapper modelMapper,
                                    DepartmentService departmentService,
                                    SubDepartmentRepository subDepartmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentService = departmentService;
        this.subDepartmentRepository = subDepartmentRepository;
    }

    @Override
    @Transactional
    public void createSubDepartment() {
//        SubDepartment subDepartment = SubDepartment.builder()
//                .id(1L)
//                .name("Hello")
//                .code("HELLO")
//                .status('Y')
//                .department((departmentService.fetchDepartmentById(1L))).build();
//
//        SubDepartment subDepartment2 = SubDepartment.builder()
//                .id(2L)
//                .name("Adele")
//                .code("ADELE")
//                .status('Y')
//                .department((departmentService.fetchDepartmentById(1L))).build();

        SubDepartment subDepartment = new SubDepartment();
        subDepartment.setId(1L);
        subDepartment.setName("Jindagi");
        subDepartment.setCode("HE");
        subDepartment.setStatus('Y');
        subDepartment.setDepartment(departmentService.fetchDepartmentById(1L));

        SubDepartment subDepartment2 = new SubDepartment();
        subDepartment2.setId(2L);
        subDepartment2.setName("Adele");
        subDepartment2.setCode("AD");
        subDepartment2.setStatus('Y');
        subDepartment2.setDepartment(departmentService.fetchDepartmentById(1L));

        SubDepartment subDepartment3 = new SubDepartment();
        subDepartment3.setId(3L);
        subDepartment3.setName("Hello");
        subDepartment3.setCode("LOL LOL LOL");
        subDepartment3.setStatus('Y');
        subDepartment3.setDepartment(departmentService.fetchDepartmentById(1L));

        SubDepartment subDepartment4 = new SubDepartment();
        subDepartment4.setId(4L);
        subDepartment4.setName("Hello");
        subDepartment4.setCode("GOL GOL GOL");
        subDepartment4.setStatus('Y');
        subDepartment4.setDepartment(departmentService.fetchDepartmentById(1L));


        subDepartmentRepository.save(subDepartment);
        subDepartmentRepository.save(subDepartment2);
        subDepartmentRepository.save(subDepartment3);
        subDepartmentRepository.save(subDepartment4);

    }

    @Override
    public SubDepartmentResponseDTO fetchSubDepartmentById(Long id) {
        //YOU CAN CHECK BY DEBUGGING HERE :D :D BLEH!!
        Optional<SubDepartment> subDepartmentObj = subDepartmentRepository.findById(id);

        return subDepartmentObj
                .map(subDepartment -> modelMapper.map(subDepartment, SubDepartmentResponseDTO.class))
                .orElseThrow(resourceNotFound(id));
    }

    public SubDepartmentResponseDTO fetchSubDepartmentAndDepartmentById(Long id, Boolean includeDepartment) {
        if (includeDepartment) {

            return subDepartmentRepository.findWithDepartmentById(id).map(subDepartment -> {
                SubDepartmentResponseDTO subDeptDTO = modelMapper.map(subDepartment, SubDepartmentResponseDTO.class);
                //explicitly add department.
                subDeptDTO.setDepartmentResponseDTO(modelMapper.map(subDepartment.getDepartment(), DepartmentResponseDTO.class));
                return subDeptDTO;
            }).orElseThrow(resourceNotFound(id));
        } else {
            return fetchSubDepartmentById(id);
        }
    }

    @Override
    public Integer findSubDepartmentCountByName(String name) {
        return subDepartmentRepository.findSubDepartmentCountByName(name);
    }

    private Supplier<IllegalArgumentException> resourceNotFound(Long subDeptId) {
        return () ->
                new IllegalArgumentException(String.format("The DepartmentId: %d is not found!", subDeptId));
    }


}
