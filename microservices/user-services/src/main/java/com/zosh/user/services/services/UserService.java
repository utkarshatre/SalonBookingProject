package com.zosh.user.services.services;

import com.zosh.user.services.exception.UserException;
import com.zosh.user.services.modal.User;

import java.util.List;

public interface UserService {
     User createUser(User user);
    List<User> getAllUser();
    User getUserBYID(Long ID) throws UserException;
    void deleteUserByID(Long ID) throws UserException;
    User updateUserById(Long ID, User user) throws UserException;
}
