package dev.innov8.dtos;

import dev.innov8.models.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DepartmentDTO {

    private int id;
    private String name;
    private List<EmployeeDTO> employees;

    public DepartmentDTO() {
        super();
        this.employees = new ArrayList<>();
    }

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public DepartmentDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DepartmentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public DepartmentDTO setEmployees(List<EmployeeDTO> employees) {
        if (employees == null) return this;
        this.employees = employees;
        return this;
    }

    public DepartmentDTO addEmployees(EmployeeDTO... employees) {
        this.employees.addAll(Arrays.asList(employees));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
