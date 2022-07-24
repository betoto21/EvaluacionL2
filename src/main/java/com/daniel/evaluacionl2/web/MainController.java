package com.daniel.evaluacionl2.web;

import com.daniel.evaluacionl2.domain.Contract;
import com.daniel.evaluacionl2.domain.Employee;
import com.daniel.evaluacionl2.domain.ViewEmployee;
import com.daniel.evaluacionl2.service.IContractService;
import com.daniel.evaluacionl2.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/")
    public String init(Model model){
        Queries queries = new Queries();
        List<ViewEmployee> employees = null;
        try {
            employees = queries.getEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        log.info("Executing Controller");

        return "index";
    }

    @GetMapping("/addcontract")
    public String addContract(Model model){
        model.addAttribute("contract", new Contract());
        return "addcontract";
    }


    @PostMapping("/savecontract")
    public String saveContract(Contract contract, Model model){
        contract.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
        contract.setIsActive(1);
        contractService.saveContract(contract);
        return "redirect:/";
    }

    @GetMapping("/addemployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "addemployee";
    }

    @PostMapping("/saveemployee")
    public String saveEmployee(Employee employee, Model model){
        employee.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));
        employee.setIsactive(1);
        boolean isright = employeeService.isAllRight(employee);
        if (!isright){
            model.addAttribute("error", "Hubo un error al verificar el rfc");
            return "redirect:/addemployee";
        }
        model.addAttribute("error", "");
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(Employee employee, Model model){
        Employee employee1 = employeeService.searchEmployee(employee);
        model.addAttribute("employee", employee1);
        return "edit";
    }

    @PostMapping("/saveedit")
    public String saveEdit(Employee employee, Model model){
        employee.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));
        employee.setIsactive(1);
        boolean isright = employeeService.isAllRight(employee);
        if (!isright){
            model.addAttribute("error", "Hubo un error al verificar el rfc");
            return "redirect:/addemployee";
        }
        model.addAttribute("error", "");
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/end")
    public String endContract(Employee employee, Model model){
        List<Employee> employees = employeeService.listEmployees();
        for (Employee em : employees){
            if (em.getTaxidnumber().equals(employee.getTaxidnumber())){
                employee.setEmployeeid(em.getEmployeeid());
                break;
            }
        }

        List<Contract> contracts = contractService.listContract();
        for (Contract com : contracts){
            if (com.getEmployeeId() == employee.getEmployeeid()){
                com.setIsActive(0);
                contractService.saveContract(com);
                break;
            }
        }
        return "redirect:/";
    }
}
