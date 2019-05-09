package com.ntl.trello.repository;

import com.ntl.trello.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query(value = "SELECT * FROM project AS p " +
            "INNER JOIN users_project AS up ON p.id = up.project_id " +
            "WHERE up.users_id = :users_id", nativeQuery = true)
    List<Project> getAllProjectByUserId(@Param("users_id")int users_id);
}
