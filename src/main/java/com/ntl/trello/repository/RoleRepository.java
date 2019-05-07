package com.ntl.trello.repository;

import com.ntl.trello.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query(value = "SELECT * FROM role AS r " +
            "INNER JOIN users_role AS ur ON r.id = ur.role_id " +
            "WHERE ur.users_id = :users_id", nativeQuery = true)
    List<Role> findAllRoleByUserId(@Param("users_id") long users_id);

}
