package com.carService.carService.Interface;

import com.carService.carService.DTO.UserDto;
import com.carService.carService.Model.User;

import java.util.List;

public interface IUser {
    String signupUser(UserDto userDto);

    String loginUser(String mail, String password);

    String verify(String mail, Integer otp);

    User displayUserDetails(String mail);

    List<User> dispayAllUser();

    String updateUser(User user, String mail);

    String deleteUser(String mail);
}
