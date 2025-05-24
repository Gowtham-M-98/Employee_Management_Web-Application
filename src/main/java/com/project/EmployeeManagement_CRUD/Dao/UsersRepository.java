package com.project.EmployeeManagement_CRUD.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EmployeeManagement_CRUD.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByUserName(String username);

}
