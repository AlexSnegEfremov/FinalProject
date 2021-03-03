package com.example.spring.boot.projekt.Efremov.service;

import com.example.spring.boot.projekt.Efremov.dao.UserDao;
import com.example.spring.boot.projekt.Efremov.modal.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
@Data
public class UserService implements UserDetailsService {
    //@Autowired lombok constructor
    private final UserDao userRepository;

    private final Map<String, String> googleUsers = new HashMap<>();

  /*  @Autowired
    public UserService(UserDao userRepository) {
        this.userRepository = userRepository;
    }*/

    public void saveUser(User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //потестировал для общего развития lombok логирование Slf4j
        log.info("метод отработал успешно или не успешно , короч сам смотри=)");
        userRepository.save(user);

    }

    public void updateUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!userRepository.getOne(user.getId()).getPassword().equals(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }

    public User getUserByLogin(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    //переопределяем метод из UserDetailsService для прохождения авторизации , стандартно на login настроено поменял на email
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (googleUsers.containsKey(s)) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(s)
                    .password(googleUsers.get(s))
                    .authorities("USER")
                    .build();
        }
        return userRepository.findByEmail(s);
    }

    public void addGoogleUser(String name, String password) {
        googleUsers.put(name, password);
    }

}
