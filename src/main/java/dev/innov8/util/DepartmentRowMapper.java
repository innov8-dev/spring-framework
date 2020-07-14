package dev.innov8.util;

import dev.innov8.models.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentRowMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int i) throws SQLException {

        Department department = new Department();

        department.setId(rs.getInt("id"))
                  .setName(rs.getString("name"));

        return department;

    }

}
