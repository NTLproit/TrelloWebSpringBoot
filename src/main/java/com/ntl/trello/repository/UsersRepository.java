package com.ntl.trello.repository;

import com.ntl.trello.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
    Users findById(int id);
}
