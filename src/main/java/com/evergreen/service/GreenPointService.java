package com.evergreen.service;

import com.evergreen.dao.GreenPointRepository;
import com.evergreen.entities.GreenPoint;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class GreenPointService {
    @Autowired
    private GreenPointRepository greenPointRepository;

    public Optional<GreenPoint> getGreenPoint(final Long id) {
        return greenPointRepository.findById(id);
    }
    public List<GreenPoint> getGreenPoints() {
        return greenPointRepository.findAll();
    }
    public GreenPoint saveGreenPoint(GreenPoint greenPoint) {
        GreenPoint savedGreenPoint = greenPointRepository.save(greenPoint);
        return savedGreenPoint;
    }
    public void deleteGreenPoint(long id){
        greenPointRepository.deleteById(id);
    }
}
