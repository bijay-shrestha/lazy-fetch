package com.bijay.lazy.fetch.query;

public class SubDepartmentQuery {

    public static final String GET_SUB_DEPARTMENT_COUNT_BY_NAME =
            "SELECT * FROM sub_department s WHERE s.name=:name";
}
