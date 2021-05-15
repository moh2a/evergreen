package com.evergreen.service;

import java.util.List;
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

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
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
    
    public boolean isUserExisting(String email) {
        Iterable<User> users = getUsers();
    	for (User user : users) {
    		if (email.equals(user.getEmail())) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    private static String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
    
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
