package com.example.demo.controller;

import com.example.demo.repository.model.UserEntity;
import com.example.demo.repository.model.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserInfo> resultUsers = new ArrayList<>();
        for (UserEntity user : users) {
            resultUsers.add(new UserInfo(user.getId(), user.getFirstName(), user.getLastName(), user.getAge()));
        }

        return ResponseEntity.ok(resultUsers);
    }

    @PostMapping("/users")
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo) {
        UserEntity user = userRepository.save(new UserEntity(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getAge()));
        return ResponseEntity.ok(new UserInfo(user.getId(), userInfo.getFirstName(), userInfo.getLastName(), userInfo.getAge()));
    }
    @PostMapping("/users/editname")
    public ResponseEntity<UserInfo> editUser() {
        List <UserEntity> users= userRepository.findAll();
        for (UserEntity user: users){
            user.setFirstName("Markus");
        }
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/users/editlastname")
    public ResponseEntity<UserInfo> editlastnameUser() {
        List <UserEntity> users= userRepository.findAll();
        for (UserEntity user: users){
            user.setLastName("Muzafarov");
        }
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/users/editage")
    public ResponseEntity<UserInfo> editageUser() {
        List <UserEntity> users= userRepository.findAll();
        for (UserEntity user: users){
            user.setAge(100);
        }
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}