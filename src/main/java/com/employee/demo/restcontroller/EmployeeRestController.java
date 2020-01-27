package com.employee.demo.restcontroller;

import com.employee.demo.Entity.Employee;
import com.employee.demo.dao.EmployeeDAO;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee= employeeService.findById(id);

        if(employee==null){
            throw new RuntimeException("Employee id not found"+ id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        Employee employee= employeeService.findById(id);
        if(employee==null){
            throw new RuntimeException("Employee not found"+ id);

        }
        employeeService.deleteById(id);

        return "Employee has been deleted";
    }

}
