package com.evergreen.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.EventUser;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long>{

	Iterable<EventUser> findEventUsersByUserId(Long user_id);

}
