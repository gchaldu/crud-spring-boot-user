package com.api.crud_api_rest.services;

import com.api.crud_api_rest.models.UserModel;
import com.api.crud_api_rest.repositorios.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepositorio iUserRepositorio;

    public List<UserModel> getUsers(){
        return iUserRepositorio.findAll();
    }

    public UserModel saveUser(UserModel userModel){
        return this.iUserRepositorio.save(userModel);
    }

    public Optional<UserModel> findByIdUser(Long id){
        return this.iUserRepositorio.findById(id);
    }

    public Boolean deleteUser(UserModel userModel){
        try{
            this.iUserRepositorio.delete(userModel);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean deleteByIdUser(Long id){
        try{
            this.iUserRepositorio.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<UserModel> updateUser2(Long id, UserModel userModel) {
        Optional<UserModel> userOptional = this.findByIdUser(id);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setEmail(userModel.getEmail());

            return Optional.of(this.iUserRepositorio.save(user));
        } else {
            throw new NoSuchElementException("User not found with id: " + id);
        }
    }

    public UserModel updateUser(Long id, UserModel userModel) {
        UserModel user = this.findByIdUser(id).get();

        if (user!=null) {
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setEmail(userModel.getEmail());

            return this.iUserRepositorio.save(user);
        } else {
            throw new NoSuchElementException("User not found with id: " + id);
        }
    }



}
