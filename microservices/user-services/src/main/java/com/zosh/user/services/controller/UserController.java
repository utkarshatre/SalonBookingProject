    package com.zosh.user.services.controller;

    import ch.qos.logback.core.net.SyslogOutputStream;
    import com.zosh.user.services.exception.UserException;
    import com.zosh.user.services.modal.User;
    import com.zosh.user.services.repository.UserRepository;
    import com.zosh.user.services.services.UserService;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.hibernate.jdbc.Expectation;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.RequestEntity;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    import org.springframework.web.bind.annotation.*;

    import javax.print.attribute.standard.DateTimeAtCreation;
    import java.sql.Date;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequiredArgsConstructor
    public class UserController {

    private final UserService userService;

    // ************below things do the same things what Requried ArgsConstructor do
    //public UserController(UserService user){
    //    this.userService= user;
    //}

        @PostMapping("/api/user/details")
        public ResponseEntity<User> createUser(@RequestBody @Valid User user){
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }

    //    **************************for dynamic data getting******************************
        @GetMapping("/api/user/details")
        public ResponseEntity<List<User>> getUserApi(){
            List<User> getUser = userService.getAllUser();
            return new ResponseEntity<>(getUser,HttpStatus.OK);
        }

        @GetMapping("api/user/details/{id}")
        public ResponseEntity<User> getUserByIdApi(@PathVariable("id") Long basedOnID) throws Exception{
            User user = userService.getUserBYID(basedOnID);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        @PutMapping("/api/user/details/{id}")
        public ResponseEntity<User> updateUserApi(@RequestBody User user, @PathVariable("id") Long basedONID) throws Exception{
           User particular_User=  userService.updateUserById(basedONID, user);
           return new ResponseEntity<>(particular_User, HttpStatus.OK);
        }
    @PatchMapping("/api/user/details/{id}")
        public ResponseEntity<User> updateUserPatchApi(@RequestBody User user , @PathVariable Long id)throws Exception{
        User particular_User = userService.updateUserById(id, user);
        return new ResponseEntity<>(particular_User,HttpStatus.OK);
        }
        @DeleteMapping("/api/user/details/{id}")                                //Delete User by Directly
        public ResponseEntity<String> DeleteUserApi(@PathVariable Long id) throws Exception{
             userService.deleteUserByID(id);
            return new ResponseEntity<>("User Deleted Successfully",HttpStatus.ACCEPTED);
        }
    }
