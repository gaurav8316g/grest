package com.learning.grest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.grest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
