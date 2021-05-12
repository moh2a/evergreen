package com.evergreen.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evergreen.dao.UserRepository;
import com.evergreen.entities.User;

import lombok.Data;

@Data
@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
    	user.setPassword(hashPassword(user.getPassword()));
    	user.setRole("Utilisateur");
        User savedUser = userRepository.save(user);
        return savedUser;
    }
    
    private static String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
    
    private static boolean checkPassword(String password, String hashedPassword) {
		if (BCrypt.checkpw(password, hashedPassword)) {
			return true;
		}
		
		return false;
    }
}
