package dev.innov8.repositories;

import dev.innov8.models.Employee;
import dev.innov8.util.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;
    private EmployeeRowMapper rowMapper;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate, EmployeeRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("select * from employees", rowMapper);
    }

    public List<Employee> findEmployeesByDepartmentId(int departmentId) {
        return jdbcTemplate.query("select * from employees where department_id = ?", rowMapper, departmentId);
    }

    public Employee findEmployeeById(int id) {
        return jdbcTemplate.queryForObject("select * from employees where id = ?", rowMapper, id);
    }

    public boolean saveEmployee(Employee emp) {
        String sql = "insert into employees (first_name, last_name, department_id) values (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId()) > 0;
    }

    public boolean updateEmployee(Employee emp) {
        String sql = "update employees set first_name = ?, last_name = ?, department_id = ? where id = ?";
        return jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getId()) > 0;
    }

    public boolean deleteEmployeeById(int id) {
        return jdbcTemplate.update("delete from employees where id = ?", id) > 0;
    }

}
