package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.dao.IEmployeeDAO;
import com.daniel.evaluacionl2.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeServiceImplentation implements IEmployeeService{

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> listEmployees() {
        return (List<Employee>) employeeDAO.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteById(employee.getEmployeeid());
    }

    @Override
    @Transactional(readOnly = true)
    public Employee searchEmployee(Employee employee) {
        return employeeDAO.findById(employee.getEmployeeid()).orElse(null);
    }

    @Override
    public boolean isAllRight(Employee employee){
        List<Employee> employees = listEmployees();
        for (Employee employee1 : employees){
            if (employee1.getTaxidnumber().equals(employee.getTaxidnumber())){
                return false;
            }
        }
        Pattern pat = Pattern.compile("/^[A-ZÑ&]{3,4}\\d{6}(?:[A-Z\\d]{3})?$/");
        Matcher mat = pat.matcher(employee.getTaxidnumber());
        if(mat.matches()){
            return false;
        }
        return true;
    }
}
