package com.evergreen.dao;

import com.evergreen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.entities.GreenPoint;

import java.util.List;
import java.util.Optional;

@Repository
public interface GreenPointRepository extends JpaRepository<GreenPoint, Long>{
    List<GreenPoint> findGreenPointsByIdNettoyeur(Long idNettoyeur);

}
