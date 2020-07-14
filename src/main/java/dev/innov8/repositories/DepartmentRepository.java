package dev.innov8.repositories;

import dev.innov8.dtos.EmployeeDTO;
import dev.innov8.models.Department;
import dev.innov8.services.EmployeeService;
import dev.innov8.util.DepartmentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    private JdbcTemplate jdbcTemplate;
    private DepartmentRowMapper rowMapper;

    @Autowired
    public DepartmentRepository(JdbcTemplate jdbcTemplate, DepartmentRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public List<Department> findAllDepartments() {
        return jdbcTemplate.query("select * from departments", rowMapper);
    }

    public Department findDepartmentById(int id) {
        return jdbcTemplate.queryForObject("select * from departments where id = ?", rowMapper, id);
    }

    public boolean  deleteDepartmentById(int id) {
        return jdbcTemplate.update("delete from departments where id = ?", id) > 0;
    }

}
