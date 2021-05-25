package com.evergreen.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.EventUser;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long>{

	Optional<EventUser> findUserById(Long user_id);
	Optional<EventUser> findEventById(Long event_id);

}
