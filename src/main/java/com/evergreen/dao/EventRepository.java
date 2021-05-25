package com.evergreen.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	Iterable<Event> findEventByDateAfter(Date currentDate);
	Iterable<Event> findEventByDateBefore(Date currentDate);

}
