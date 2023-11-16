package com.pma.deo;

import com.pma.dto.EmployeeProject;
import com.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees" )
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.EMPLOYEE_ID,e.first_name as firstName, e.last_name as lastName, count(pe.employee_id) as projectCount FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id group by e.first_name, e.last_name order by 3 desc\n")
    public List<EmployeeProject> employeeProjects();

    public Employee findByEmail(String value);

    public Employee findByEmployeeId(long theId);
}
