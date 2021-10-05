package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
