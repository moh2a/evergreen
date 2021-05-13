package com.evergreen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.GreenPoint;

@Repository
public interface GreenPointRepository extends JpaRepository<GreenPoint, Long>{

}
