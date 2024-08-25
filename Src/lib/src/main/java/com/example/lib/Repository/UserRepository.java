package com.example.lib.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lib.model.User;

public interface UserRepository extends JpaRepository<User,Long>  {

	User findByUsername(String username);

}
