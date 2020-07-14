package dev.innov8.util;

import dev.innov8.models.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {

        Employee employee = new Employee();

        employee.setId(rs.getInt("id"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setDepartmentId(rs.getInt("department_id"));

        return employee;

    }

}
