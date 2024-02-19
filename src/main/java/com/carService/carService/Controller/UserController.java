package com.carService.carService.Controller;

import com.carService.carService.DTO.UserDto;
import com.carService.carService.Interface.IUser;
import com.carService.carService.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUser iUser;

    @PostMapping("/signupUser")
    public ResponseEntity<?> signupUser(@RequestBody UserDto userDto){
        try {
            String message =iUser.signupUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestParam String mail, @RequestParam String password){
        try {
            String message = iUser.loginUser(mail,password);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/verifyUser")
    public ResponseEntity<?> verify(@RequestParam String mail, @RequestParam Integer otp){
        try {
            String message = iUser.verify(mail,otp);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/displayUserDetails")
    public ResponseEntity<?> displayUserDetails(@RequestParam String mail){
        try {
            User message = iUser.displayUserDetails(mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/displayAllUser")
    public ResponseEntity<?> displayAllUser(){
        List<User> user = iUser.dispayAllUser();
        return (ResponseEntity<?>) user;
    }
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user,@RequestParam String mail){
        try {
            String message = iUser.updateUser(user,mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam String mail){
        try {
            String message = iUser.deleteUser(mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
