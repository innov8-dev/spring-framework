package dev.innov8.dtos;

import dev.innov8.models.Employee;

import java.util.Objects;

public class EmployeeDTO {

    private int id;
    private String firstName;
    private String lastName;
    private DepartmentDTO department;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.department = new DepartmentDTO().setId(employee.getId());
    }

    public int getId() {
        return id;
    }

    public EmployeeDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public EmployeeDTO setDepartment(DepartmentDTO department) {
        this.department = department;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO employee = (EmployeeDTO) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                '}';
    }

}
