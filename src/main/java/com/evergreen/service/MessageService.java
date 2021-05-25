package com.evergreen.service;

import com.evergreen.dao.MessageRepository;
import com.evergreen.entities.Message;
import com.evergreen.entities.Sujet;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Optional<Message> getMessage(final Long id) {
        return messageRepository.findById(id);
    }
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
    public Page<Message> getMessagesPaginate(Integer start, Integer end) {
        Pageable firstPageWithTwoElements = PageRequest.of(start, end, Sort.by("updatedAt").descending());
        return messageRepository.findAll(firstPageWithTwoElements);
    }
    public Message save(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> getMessagesByIdSujet(Long idSujet){ return messageRepository.findBySujetId(idSujet,Sort.by("updatedAt").ascending());}
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
