package dev.innov8.services;

import dev.innov8.dtos.DepartmentDTO;
import dev.innov8.dtos.EmployeeDTO;
import dev.innov8.models.Employee;
import dev.innov8.repositories.EmployeeRepository;
import dev.innov8.util.EmployeeDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepo;
    private EmployeeDtoMapper dtoMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo, EmployeeDtoMapper dtoMapper) {
        this.employeeRepo = employeeRepo;
        this.dtoMapper = dtoMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAllEmployees()
            .stream()
            .map(dtoMapper::mapModelToDto)
            .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByDepartmentId(int departmentId) {
        return employeeRepo.findEmployeesByDepartmentId(departmentId)
                .stream()
                .map(dtoMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee emp = employeeRepo.findEmployeeById(id);
        return dtoMapper.mapModelToDto(emp);
    }

    public boolean saveNewEmployee(Employee newEmployee) {
        return employeeRepo.saveEmployee(newEmployee);
    }

    public boolean updateEmployee(Employee updatedEmployee) {
        return employeeRepo.updateEmployee(updatedEmployee);
    }

    public boolean deleteEmployeeById(int id) {
        return employeeRepo.deleteEmployeeById(id);
    }

}
