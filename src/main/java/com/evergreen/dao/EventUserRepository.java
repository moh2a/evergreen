package com.evergreen.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.EventUser;
import com.evergreen.entities.User;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long>{

	Iterable<EventUser> findEventUsersByUserId(long user_id);
	Optional<EventUser> findEventUserByEventIdAndUserId(long event_id, long user_id);
	Iterable<EventUser> deleteAllByEventId(long event_id);

}
