package com.evergreen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
