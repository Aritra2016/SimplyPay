package com.aritra.SimplyPay.Service;

import com.aritra.SimplyPay.Entity.User;

import java.util.List;

public interface UserService {

    User createuser(User user);

    User getUserById(Long id);
    User getuserByEmail(String mail);

    List<User> getAllUsers();
}
