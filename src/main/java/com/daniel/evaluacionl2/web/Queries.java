package com.daniel.evaluacionl2.web;

import com.daniel.evaluacionl2.domain.Contract;
import com.daniel.evaluacionl2.domain.Employee;
import com.daniel.evaluacionl2.domain.ViewEmployee;
import com.daniel.evaluacionl2.service.ContractServiceImplementation;
import com.daniel.evaluacionl2.service.IContractService;
import com.daniel.evaluacionl2.service.IEmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Queries {

    private static final String url = "jdbc:mysql://localhost/metaphorcebd";
    private static final String user = "root";
    private static final String pass = "root";
    private static final String sql = "call ViewEmployee";

    @Autowired
    private IEmployeeService employeeService;

    public List<ViewEmployee> getEmployees() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ViewEmployee> viewEmployeeList;
        try {
            con = DriverManager.getConnection(url, "root", "root");
            viewEmployeeList = new ArrayList<>();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String lastName = rs.getString(2);
                String Tax = rs.getString(3);
                String email = rs.getString(4);
                String nameContract = rs.getString(5);
                Date dateFrom = rs.getDate(6);
                Date dateTo = rs.getDate(7);
                double salary = rs.getDouble(8);
                ViewEmployee viewEmployee = new ViewEmployee();
                viewEmployee.setFullname(name + " " + lastName);
                viewEmployee.setTaxidnumber(Tax);
                viewEmployee.setEmail(email);
                viewEmployee.setContractname(nameContract);
                viewEmployee.setDatefrom(dateFrom);
                viewEmployee.setDateto(dateTo);
                viewEmployee.setSalary(salary);
                viewEmployee.setIdemployee(rs.getLong(9));
                viewEmployeeList.add(viewEmployee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return viewEmployeeList;
    }

    public boolean isTaxRight(Employee employee){
        Pattern pat = Pattern.compile("/^[A-ZÑ&]{3,4}\\d{6}(?:[A-Z\\d]{3})?$/");
        Matcher mat = pat.matcher(employee.getTaxidnumber());
        if(!mat.matches()){
            return false;
        }
        return true;
    }

    public boolean isTaxRegistry(Employee employee){
        List<Employee> employees = employeeService.listEmployees();
        for (Employee employee1 : employees){
            if (employee.getTaxidnumber().equalsIgnoreCase(employee.getTaxidnumber())){
                return false;
            }
        }
        return true;
    }
}
