package com.RITBilliardsBoard.backend.auth.service;

import com.RITBilliardsBoard.backend.entity.User;
import com.RITBilliardsBoard.backend.auth.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    // Method to load user details by username (email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database by email (username)
        Optional<User> userInfo = repository.findByEmail(username);

        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Convert UserInfo to UserDetails (UserInfoDetails)
        User user = userInfo.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), List.of(user.getRole())); //TODO WEWEWEW
    }

    // Add any additional methods for registering or managing users
    public String addUser(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already in use!";
        }
        // Encrypt password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return "User added successfully!";
    }


    /**
     * Fetch a user by email.
     * @param email the email of the user
     * @return Optional of UserInfo
     */
    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
