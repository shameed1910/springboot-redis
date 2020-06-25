package com.example.redis.springbootredisdemo.controller;

import com.example.redis.springbootredisdemo.model.Employee;
import com.example.redis.springbootredisdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

   @PostMapping("/employees")
    public Employee saveEMployee(@RequestBody Employee employee){
        employeeRepository.saveEmployee(employee);
        return employee;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return employeeRepository.findById(id);
    }

    @PutMapping("/employees")
    public void update(@RequestBody Employee employee){
        employeeRepository.update(employee);

    }
    @DeleteMapping("/employees/{id}")
    public  void delete(@PathVariable("id") Integer id){
        employeeRepository.delete(id);
    }



}
