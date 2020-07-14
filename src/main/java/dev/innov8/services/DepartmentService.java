package dev.innov8.services;

import dev.innov8.dtos.DepartmentDTO;
import dev.innov8.dtos.EmployeeDTO;
import dev.innov8.repositories.DepartmentRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements InitializingBean {

    private DepartmentRepository departmentRepo;
    private EmployeeService employeeService;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepo.findAllDepartments()
                             .stream()
                             .map(DepartmentDTO::new)
                             .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(int id) {
        return new DepartmentDTO(departmentRepo.findDepartmentById(id));
    }

    public boolean deleteDepartmentById(int id) {
        List<EmployeeDTO> departmentEmployees = employeeService.getEmployeesByDepartmentId(id);
        departmentEmployees.forEach(emp -> employeeService.deleteEmployeeById(emp.getId()));
        return departmentRepo.deleteDepartmentById(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (employeeService == null) {
            throw new IllegalStateException("No EmployeeService found for DepartmentService!");
        }
    }
}
