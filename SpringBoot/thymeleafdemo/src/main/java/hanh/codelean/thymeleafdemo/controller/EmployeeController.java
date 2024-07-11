package hanh.codelean.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import hanh.codelean.thymeleafdemo.model.Employee;

import java.util.ArrayList;

@Controller
@SpringBootApplication
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){
        Employee emp1 = new Employee( 1, "hanh", "do", "hah@gmail.com");
        Employee emp2 = new Employee( 2, "nga", "nguyen", "nga@gmail.com");
        Employee emp3 = new Employee( 3, "thao", "pham", "thao@gmail.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);

    }

    @GetMapping("list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);
        return "list_employees";
    }
}
