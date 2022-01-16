package com.emma.app.rest.Controllers;

import com.emma.app.rest.Models.Users;
import com.emma.app.rest.Repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<Users> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody Users users){
        userRepo.save(users);
        return "Saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody Users users){
        Users updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(users.getFirstName());
        updateUser.setLastName(users.getLastName());
        updateUser.setOccupation(users.getOccupation());
        updateUser.setAge(users.getAge());
        userRepo.save(updateUser);
        return "Updated....";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id: " + id;
    }
}
