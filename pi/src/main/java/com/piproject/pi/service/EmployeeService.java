package com.piproject.pi.service;

import com.piproject.pi.exception.UserNotFoundException;
import com.piproject.pi.model.Employee;
import com.piproject.pi.repo.Employeerepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EmployeeService {
    private final Employeerepo employeerepo;
    @Autowired
    public EmployeeService(Employeerepo employeerepo) {
        this.employeerepo = employeerepo;
    }




    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeerepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeerepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeerepo.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id){
        employeerepo.deleteEmployeeById(id);
    }
    public Employee findEmployeeById(Long id){
        return employeerepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id "+ id + " was not found"));

    }
}
