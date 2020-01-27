package com.employee.demo.dao;

import com.employee.demo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);
    public void save(Employee employee);

    public void deleteById(int id);
}
