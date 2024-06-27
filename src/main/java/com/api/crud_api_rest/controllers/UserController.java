package com.api.crud_api_rest.controllers;

import com.api.crud_api_rest.models.UserModel;
import com.api.crud_api_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/")
    public UserModel saveUser(@RequestBody UserModel userModel){
        return this.userService.saveUser(userModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> findById(@PathVariable("id") Long id) {
        return this.userService.findByIdUser(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUser(@PathVariable("id") Long id, @RequestBody UserModel userModel){
        return this.userService.updateUser(id, userModel);
    }

//    @DeleteMapping(path = "/{id}")
//    public void deleteUser(@RequestBody UserModel userModel){
//        this.userService.deleteUser(userModel);
//    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        Boolean ok = this.userService.deleteByIdUser(id);
        if(ok){
            return "El user con ID: " + id + "Eliminado!!!!";
        }

        return "Error el eliminar el User ID: " + id;
    }



}
