package com.afs.restapi.repository;

import com.afs.restapi.entity.Employee;
import com.afs.restapi.exception.NoEmployeeFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(1, "Julia", 18, "Female",1, 100000));
        employees.add(new Employee(2, "Jason", 18, "Male",1, 100000));
        employees.add(new Employee(3, "Klaus", 18, "Male", 1,100000));
        employees.add(new Employee(4, "Joanne", 18, "Female",1, 100000));
        employees.add(new Employee(5, "John", 18, "Male",1, 100000));
        employees.add(new Employee(6, "Johnson", 18, "Male", 1,100000));
        employees.add(new Employee(7, "Nicole", 18, "Female",1,100000));
    }


    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Integer id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(NoEmployeeFoundException::new);
    }

    public List<Employee> findByGender(String gender) {
        return employees.stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public List<Employee> findByPage(Integer page, Integer pageSize) {
        return employees.stream()
                .skip((long)(page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        Integer nextId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0) + 1;
        employee.setId(nextId);
        employees.add(employee);
        return employee;
    }

    public Employee save(Integer id, Employee updatedEmployee) {
        Employee employee = findById(id);
        employees.remove(employee);
        employees.add(updatedEmployee);
        return updatedEmployee;
    }

    public Employee remove(Integer id) {
        Employee employee = findById(id);
        employees.remove(employee);
        return employee;
    }

    public void clearAll() {
        employees.clear();
    }
}
