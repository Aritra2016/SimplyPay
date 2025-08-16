package com.aritra.SimplyPay.Controller;

import com.aritra.SimplyPay.Entity.User;
import com.aritra.SimplyPay.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/users/")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // UserService instance to handle user-related operations.

    private UserService userService;

    /**
     * Constructor for UserController.
     * @param userService The UserService to be used by this controller.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method is used to create a new user.
     * @param user The user object to be created.
     * @return ResponseEntity containing the created user and HTTP status code.
     */

    @PostMapping
     public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("Creating user: {}", user);
        User createuser=userService.createuser(user);
        return   ResponseEntity.status(HttpStatus.CREATED).body(createuser);
     }

     @GetMapping("/{id}")
     public ResponseEntity<User> getSingleUser(@PathVariable Long id){
         /**
          * This method is used to get a user by their ID.
          * @param id The ID of the user to be retrieved.
          * @return ResponseEntity containing the user object if found, or a NOT FOUND status if not found.
          */

        return  ResponseEntity.ok(userService.getUserById(id));
     }

     @GetMapping("/allUsers")
     public ResponseEntity<User> getAllUsers(){
        return ResponseEntity.ok((User) userService.getAllUsers());
     }
}
