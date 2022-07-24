package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> listEmployees();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public Employee searchEmployee(Employee employee);

    public boolean isAllRight(Employee employee);
}
