package dev.innov8.util;

import dev.innov8.dtos.DepartmentDTO;
import dev.innov8.dtos.EmployeeDTO;
import dev.innov8.models.Employee;
import dev.innov8.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper {

    private DepartmentService departmentService;

    @Autowired
    public EmployeeDtoMapper(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public EmployeeDTO mapModelToDto(Employee employee) {
        DepartmentDTO empDepartment = departmentService.getDepartmentById(employee.getDepartmentId());
        return new EmployeeDTO(employee).setDepartment(empDepartment);
    }

}
