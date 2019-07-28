package com.bijay.lazy.fetch.repository.custom.impl;

import com.bijay.lazy.fetch.entity.SubDepartment;
import com.bijay.lazy.fetch.repository.custom.SubDepartmentCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static com.bijay.lazy.fetch.constant.QueryParamConstant.NAME;
import static com.bijay.lazy.fetch.query.SubDepartmentQuery.GET_SUB_DEPARTMENT_COUNT_BY_NAME;

@Repository
@Transactional(readOnly = true)
public class SubDepartmentCustomRepositoryImpl implements SubDepartmentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer findSubDepartmentCountByName(String name){
        Query query = entityManager.createNativeQuery(
                GET_SUB_DEPARTMENT_COUNT_BY_NAME,
                SubDepartment.class);
        query.setParameter(NAME, name);
        return query.getResultList().size();
    }
}
