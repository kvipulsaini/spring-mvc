package com.pma.deo;

import com.pma.dto.Projects;
import com.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {

    @Autowired
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as `value` FROM PROJECT group by stage\n")
    public List<Projects> Projects();


}
