package com.zosh.user.services.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.zosh.user.services.exception.UserException;
import com.zosh.user.services.modal.User;
import com.zosh.user.services.repository.UserRepository;
import jakarta.validation.Valid;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userrepos;

    @PostMapping("/api/user/details")
    public User createUserApi(@RequestBody @Valid User user){
        return userrepos.save(user);
    }
//********************************statically se this for static getting data*********************
//    @GetMapping("/api/user/details")
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
    @GetMapping("/api/user/details")
    public List<User> getUserApi(){
        System.out.println(userrepos.findAll());
        return userrepos.findAll();
    }

    @GetMapping("api/user/details/{id}")
    public User getUserByIdApi(@PathVariable("id") Long basedOnID) throws Exception{
        Optional<User> optionalUser = userrepos.findById(basedOnID);
        if(optionalUser.isPresent()){
           return optionalUser.get();
        }
        else{
            throw new UserException("USer not found");
        }
    }
    @PutMapping("/api/user/details/{id}")
    public User updateUserApi(@RequestBody User user, @PathVariable("id") Long basedONID) throws Exception{
        Optional<User> otp = userrepos.findById(basedONID);
    User exsist ;
    if(otp.isPresent()) {
        exsist = otp.get();
        exsist.setName(user.getName());
        exsist.setPhone(user.getPhone());
        return userrepos.save(exsist);
    }
    else{
        throw new Exception("User not found with same id"+basedONID);
    }
    }
@PatchMapping("/api/user/details/{id}")
    public User updateUserPatchApi(@RequestBody User user , @PathVariable Long id)throws Exception{
        Optional<User> userOtp = userrepos.findById(id);
        User exist ;
        if(userOtp.isPresent()){
            exist = userOtp.get();
            exist.setName(user.getName());
            exist.setPhone(user.getPhone());
            return userrepos.save(exist);
        }
        else{
            throw new Exception("User not found with same id");
        }

    }
    @DeleteMapping("/api/user/details/{id}")
    public String DeleteUserApi(@PathVariable Long id) throws Exception{
        Optional<User> userOpt = userrepos.findById(id);
        User exist;
        if (userOpt.isPresent()) {
            exist = userOpt.get();
            userrepos.delete(exist);
        return ("User Deleted Successfully");
        }
        else{
            throw new Exception("USer Not Found");
        }
    }
}
