package com.zosh.user.services.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.zosh.user.services.exception.UserException;
import com.zosh.user.services.modal.User;
import com.zosh.user.services.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerBYClass {

    @Autowired
    private UserRepository userreposBYClass;

    @PostMapping("/api/userstatic/details")
    public User createUserApi(@RequestBody @Valid User user){
        return userreposBYClass.save(user);
    }
//********************************statically se this for static getting data*********************
//    @GetMapping("/api/userstatic/details")
//    public User getUserApi(){
//        User user = new User();
//        user.setName("utkarsh atre");
//        user.setEmail("utkarsh3336@gmai.com");
//        user.setPassword("4126@Utkarsh");
//        user.setRole("USER");
//        user.setAddress("Bangalore");
//        user.setPhone("7024334126");
//    return user;
//    }

    //    **************************for dynamic data getting******************************
    @GetMapping("/api/userstatic/details")
    public List<User> getUserApiStatic(){
        System.out.println(userreposBYClass.findAll());
        return userreposBYClass.findAll();
    }

    @GetMapping("api/userstatic/details/{id}")
    public User getUserByIdApiStatic(@PathVariable("id") Long basedOnID) throws Exception{
        Optional<User> optionalUser = userreposBYClass.findById(basedOnID);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new UserException("USer not found");
        }
    }
    @PutMapping("/api/userstatic/details/{id}")
    public User updateUserApiStatic(@RequestBody User user, @PathVariable("id") Long basedONID) throws Exception{
        Optional<User> otp = userreposBYClass.findById(basedONID);
        User exsist ;
        if(otp.isPresent()) {
            exsist = otp.get();
            exsist.setName(user.getName());
            exsist.setPhone(user.getPhone());
            return userreposBYClass.save(exsist);
        }
        else{
            throw new UserException("User not found with same id"+basedONID);
        }
    }
    @PatchMapping("/api/userstatic/details/{id}")
    public User updateUserPatchApiStatic(@RequestBody User user , @PathVariable Long id)throws Exception{
        Optional<User> userOtp = userreposBYClass.findById(id);
        User exist ;
        if(userOtp.isPresent()){
            exist = userOtp.get();
            exist.setName(user.getName());
            exist.setPhone(user.getPhone());
            return userreposBYClass.save(exist);
        }
        else{
            throw new UserException("User not found with same id");
        }

    }
        @DeleteMapping("/api/userstatic/details/{id}")                                //Delete User by Directly
    public String DeleteUserApiStatic(@PathVariable Long id) throws Exception{
        Optional<User> userOpt = userreposBYClass.findById(id);
        User exist;
        if (userOpt.isPresent()) {
            exist = userOpt.get();
            userreposBYClass.delete(exist);
            return ("User Deleted Successfully");
        }
        else{
            throw new UserException("USer Not Found");
        }
    }
}
