package com.carService.carService.Service;

import com.carService.carService.DTO.DealarDto;
import com.carService.carService.DTO.UserDto;
import com.carService.carService.Interface.ICar;
import com.carService.carService.Model.User;
import com.carService.carService.Repo.CarRepo;
import com.carService.carService.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CarImp implements ICar {
    @Autowired
    private CarRepo carRepo;

//    @Override
//    public String signupUser(UserDto userDto) {
//        Optional<User> userDetails = userRepo.findByMail(userDto.mail);
//        if(userDetails.isPresent()){
//            throw new RuntimeException("user mail already exist");
//        }
//        Random random = new Random();
//        Integer otp = random.nextInt(8999)+1000;
//        System.out.println("OTP for this user :"+userDto.mail+" OTP IS :"+otp);
//
//        User user =new User();
//
//        user.setMail(userDto.mail);
//        user.setFirstName(userDto.firstName);
//        user.setLastName(userDto.lastName);
//        user.setVerifyStatus(false);
//        user.setPassword(userDto.Password);
//        user.setOtp(otp);
//
//        userRepo.save(user);
//        return "data added verify this account";
//    }

//    @Override
//    public String loginUser(String mail, String password) {
//        User userDetails= userRepo.findByMail(mail).orElseThrow(()->new RuntimeException("email id not found"));
//        if (!(userDetails.getPassword()).equals(password)){
//            throw new RuntimeException("password incorrect for this : "+mail);
//        }
//        if (!userDetails.getVerifyStatus()){
//            throw new RuntimeException(" first verify your account then you should login");
//        }
//
//        return "login successful";
//    }

//    @Override
//    public String signupCustomer(DealarDto customerDto) {
//        Optional<User> userDetails = customerRepo.findByEmail(customerDto.mail);
//        if(userDetails.isPresent()){
//            throw new RuntimeException("user email already exist");
//        }
//        Random random = new Random();
//        Integer otp = random.nextInt(8999)+1000;
//        System.out.println("OTP for this user :"+customerDto.mail+" OTP IS :"+otp);
//        Customer customer = new Customer();
//        customer.setMail(customerDto.mail);
//        customer.setFirstName(customerDto.firstName);
//        customer.setLastName(customerDto.lastName);
//        customer.setVerifyStatus(false);
//        customer.setPassword(customerDto.Password);
//        customer.setOtp(otp);
//        return "data added verify this account";
//    }

//    @Override
//    public String loginCustomer(String mail, String password) {
//        Customer customerDetails= customerRepo.findByEmail(mail).orElseThrow(()->new RuntimeException("mail id not Found"));
////        Customer customerDetails= customerRepo.findByMail(mail).orElseThrow(()->new RuntimeException("email id not found"));
//        if (!(customerDetails.getPassword()).equals(password)){
//            throw new RuntimeException("password incorrect for this : "+mail);
//        }
//        if (!customerDetails.getVerifyStatus()){
//            throw new RuntimeException(" first verify your account then you should login");
//        }

//        return "login successful";
//    }
}
