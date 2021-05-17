package com.evergreen.dao;

import com.evergreen.entities.Message;
import com.evergreen.entities.Sujet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySujetId(Long sujet_id);
    //Optional<Message> findByIdAndSujetId(Long id_message, Long idSujet);
}
