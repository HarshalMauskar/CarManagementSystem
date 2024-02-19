package com.carService.carService.Service;

import com.carService.carService.DTO.UserDto;
import com.carService.carService.Interface.IUser;
import com.carService.carService.Model.User;
import com.carService.carService.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserImp implements IUser {
    @Autowired
    private UserRepo userRepo;

    @Override
    public String signupUser(UserDto userDto) {
        Optional<User> userDetails= userRepo.findByMail(userDto.mail);
        if(userDetails.isPresent()){
            throw new RuntimeException("user email already exist");
        }

        Random random = new Random();
        Integer otp = random.nextInt(8999)+1000;
//        8999+1000=9999
        System.out.println("OTP for this user :"+userDto.mail+" OTP IS :"+otp);
        User user = new User();
        user.setMail((userDto.mail));
        user.setFirstName(userDto.firstName);
        user.setLastName(userDto.lastName);
        user.setVerifyStatus(false);
        user.setPassword(userDto.Password);
        user.setOtp(otp);

        userRepo.save(user);

        return "data added verify this account";
    }

    @Override
    public String loginUser(String mail, String password) {
      User user = userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
      if (!user.getPassword().equals(password)){
          throw new RuntimeException("Password is not Write");
      }
      if (user.getVerifyStatus().equals(false)){
          throw new RuntimeException("User is not Verify please verify User first Then Login");
      }
        return "login Successfully";
    }

    @Override
    public String verify(String mail, Integer otp) {
        User user = userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        if (!user.getOtp().equals(otp)){
            throw new RuntimeException("Wrong Otp");
        }
        return "Verify Successfully";
    }

    @Override
    public User displayUserDetails(String mail) {
        User user = userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        return user;

    }

    @Override
    public List<User> dispayAllUser() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public String updateUser(User user, String mail) {
        User user1 =userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        return "Details Update";
    }

    @Override
    public String deleteUser(String mail) {
        User user1 = userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        userRepo.delete(user1);
        return "user Deleted";
    }
}
