package com.aritra.SimplyPay.Service;

import com.aritra.SimplyPay.Entity.User;
import com.aritra.SimplyPay.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    /**
     * UserRepository instance to interact with the database.
     */

    private UserRepository userRepository;

    /**
     * Constructor for UserServiceImpl.
     * @param userRepository The UserRepository to be used by this service.
     */

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    /**
     * This method is used to create a new user.
     * @param user The user object to be created.
     * @return The created user object.
     */

    @Override
    public User createuser(User user) {
        return (User)userRepository.save(user);
    }


    /**
     * This method is used to get a user by their ID.
     * @param id The ID of the user to be retrieved.
     * @return The user object with the specified ID.
     */

    @Override
    public User getUserById(Long id) {
       // String s = "User is not found with id:" + id;
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User is not found with the id:"+ id));
    }

    /**
     * This method is used to get a user by their email.
     * @param mail The email of the user to be retrieved.
     * @return The user object with the specified email.
     */

    @Override
    public User getuserByEmail(String mail) {
        return userRepository.findByMail(mail).orElseThrow(()-> new RuntimeException(" User is not found with the email: " + mail));
    }

    /**
     * This method is used to get all users.
     * @return A list of all user objects.
     */

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
