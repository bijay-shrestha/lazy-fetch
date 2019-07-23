package com.bijay.lazy.fetch.entity;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

/**
 * @author Sauravi
 */


@Entity
@Table(name = "sub_department")
@NoArgsConstructor
@Getter
@Setter
public class SubDepartment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "status")
    private Character status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="department_id")
    private Department department;


}