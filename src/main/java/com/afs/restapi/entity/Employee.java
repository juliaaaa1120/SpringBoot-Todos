package com.afs.restapi.entity;

public class Employee {
    private Integer id;
    private final String name;
    private Integer age;
    private final String gender;
    private Integer companyID;
    private Integer salary;


    public Employee(Integer id, String name, Integer age, String gender, Integer companyID, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyID = companyID;
        this.salary = salary;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public Integer getCompanyId() {
        return this.companyID;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCompanyId(Integer companyID) {
        this.companyID = companyID;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

