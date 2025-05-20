package com.zosh.user.services.services.imp;

import com.zosh.user.services.exception.UserException;
import com.zosh.user.services.modal.User;
import com.zosh.user.services.repository.UserRepository;
import com.zosh.user.services.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
      return userRepository.findAll();
    }

    @Override
    public User getUserBYID(Long id) throws UserException {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()){
      return u.get();
        }
        else{
            throw new UserException("User Not Found");
        }
    }

    @Override
    public void deleteUserByID(Long id) throws UserException{
    Optional<User> opt = userRepository.findById(id);
    User exists ;
    if(opt.isPresent()){
        exists =  opt.get();
        userRepository.delete(exists);
        }
    else{
        throw new UserException("User NOT found");
        }
    }

    @Override
    public User updateUserById(Long id, User user) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            User updatedUserStatus = opt.get();
            updatedUserStatus.setPhone(user.getPhone());
            return userRepository.save(updatedUserStatus);
        }
        else{
            throw new UserException("User not Updated");
        }
    }
}
