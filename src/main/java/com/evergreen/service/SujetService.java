package com.evergreen.service;

import com.evergreen.dao.SujetRepository;
import com.evergreen.dao.UserRepository;
import com.evergreen.entities.Article;
import com.evergreen.entities.Sujet;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class SujetService {
    @Autowired
    private SujetRepository sujetRepository;

    public Optional<Sujet> getSujet(final Long id) {
        return sujetRepository.findById(id);
    }
    public List<Sujet> getSujets() {
        return sujetRepository.findAll();
    }
    public Sujet save(Sujet sujet) {
        return sujetRepository.save(sujet);
    }
    public void delete(Long id) {
        sujetRepository.deleteById(id);
    }
}
