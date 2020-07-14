package dev.innov8;

import dev.innov8.config.AppConfig;
import dev.innov8.dtos.DepartmentDTO;
import dev.innov8.dtos.EmployeeDTO;
import dev.innov8.models.Employee;
import dev.innov8.services.DepartmentService;
import dev.innov8.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppDriver {

    private static final Logger logger = LoggerFactory.getLogger(AppDriver.class);

    public static void main(String[] args) {

        logger.info("Initializing container...");
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.info("Container ready for use, and will automatically close in 5 minutes.");

        EmployeeService employeeService = container.getBean("employeeService", EmployeeService.class);

        // Get all employees
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        System.out.println(allEmployees);

        // Get employees by department id
        List<EmployeeDTO> trainingEmployees = employeeService.getEmployeesByDepartmentId(3);
        System.out.println(trainingEmployees);

        // Get employee by id
        EmployeeDTO existingEmployee = employeeService.getEmployeeById(1);
        System.out.println(existingEmployee);

        // Save new employee
        Employee mockEmployee = new Employee("New", "Guy", 4);
        employeeService.saveNewEmployee(mockEmployee);
        EmployeeDTO newEmployee = employeeService.getEmployeeById(8);
        System.out.println(newEmployee);

        // Update existing employee
        Employee mockUpdate = new Employee(8, "Howard", "Haroldson", 4);
        employeeService.updateEmployee(mockUpdate);
        EmployeeDTO updatedEmployee = employeeService.getEmployeeById(8);
        System.out.println(updatedEmployee);

        // Delete employee by id
        employeeService.deleteEmployeeById(8);
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        System.out.println(employees);

        DepartmentService departmentService = container.getBean("departmentService", DepartmentService.class);

        // Get all departments
        List<DepartmentDTO> allDepartments = departmentService.getAllDepartments();
        System.out.println(allDepartments);

        // Delete by id (maintains referential integrity)
        departmentService.deleteDepartmentById(3);
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        employees = employeeService.getEmployeesByDepartmentId(3);
        System.out.println(departments);
        System.out.println(employees);

    }

}
