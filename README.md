# Developer Note

Create a table `jindagi` with credentials as mentioned in `application.properties` file

## Sample Table Data

```sql

INSERT INTO jindagi.department
(id, code, created_by_id, created_date, department_name, last_modified_date, last_modified_by_id, status)
VALUES(1, 'BJ', 1, '2019-07-23 04:02:20.000', 'Bijay', NULL, NULL, 'Y');


INSERT INTO jindagi.sub_department
(id, code, name, status, department_id)
VALUES(1, 'HELLO', 'Hello', 'Y', 1);
INSERT INTO jindagi.sub_department
(id, code, name, status, department_id)
VALUES(2, 'ADELE', 'Adele', 'Y', 1);

```


## TEST API 1
*URL - localhost:8081/api/sub*


```json
{
    "id": 1,
    "name": "Hello",
    "code": "HELLO",
    "status": "Y",
    "departmentResponseDTO": null
}
```

## TEST API 2

*URL - localhost:8081/api/sub/1?includeDepartment=true*

```json
{
    "id": 1,
    "name": "Hello",
    "code": "HELLO",
    "status": "Y",
    "departmentResponseDTO": {
        "id": 1,
        "departmentName": "Bijay",
        "code": "BJ",
        "status": "Y",
        "createdDate": "2019-07-23T00:12:54.000+0000",
        "lastModifiedDate": null,
        "createdById": 1,
        "modifiedById": null
    }
}
```
