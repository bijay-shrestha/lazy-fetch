package com.bijay.lazy.fetch;

import com.bijay.lazy.fetch.entity.Department;
import com.bijay.lazy.fetch.service.DepartmentService;
import com.bijay.lazy.fetch.service.SubDepartmentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LazyFetchApplication {

    private final DepartmentService departmentService;
    private final SubDepartmentService subDepartmentService;

    public LazyFetchApplication(DepartmentService departmentService, SubDepartmentService subDepartmentService) {
        this.departmentService = departmentService;
        this.subDepartmentService = subDepartmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LazyFetchApplication.class, args);
    }


    @Bean
    public ApplicationRunner init(){
        return args ->{
            System.out.println("#############################¡¡¡ PERSISTING DEPARTMENTS ¡¡¡¡¡¡########################################### ...");
            departmentService.createDepartment();

            System.out.println("#############################¡¡¡ FETCHING DEPARTMENTS ¡¡¡¡¡¡########################################### ...");
            Department department = departmentService.fetchDepartmentById(1L);

            System.out.println("#############################------ PERSISTING SUB DEPARTMENTS ------ ########################################### ...");
            subDepartmentService.createSubDepartment();

            System.out.println("#############################------ FETCHING SUB DEPARTMENTS ------ ########################################### ...");
            System.out.println("Printing ============" +subDepartmentService.fetchSubDepartmentById(1L));

            System.out.println("#############################------ FETCHING SUB DEPARTMENTS WITH DEPARTMENT ------ ########################################### ...");
            System.out.println("Printing ============" +subDepartmentService.fetchSubDepartmentAndDepartmentById(1L, true));
        };
    }
}
