package com.carService.carService.Service;

import com.carService.carService.DTO.DealarDto;
import com.carService.carService.Interface.IDealar;
import com.carService.carService.Model.Dealar;
import com.carService.carService.Repo.DealarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class DealarImp implements IDealar {
    @Autowired
    private DealarRepo dealarRepo;

    @Override
    public String signupDealer(DealarDto dealarDto) {
       Optional<Dealar> dealarDetails = dealarRepo.findByMail(dealarDto.mail);
       if (dealarDetails.isPresent()){
           throw new RuntimeException("This Mail is present type another");
       }
        Random random = new Random();
        Integer otp = random.nextInt(8999)+1000;
        System.out.println("OTP for this user :"+dealarDto.mail+" OTP IS :"+otp);
        Dealar dealar = new Dealar();
        dealar.setMail((dealarDto.mail));
        dealar.setFirstName(dealarDto.firstName);
        dealar.setLastName(dealarDto.lastName);
        dealar.setVerifyStatus(false);
        dealar.setPassword(dealarDto.Password);
        dealar.setOtp(otp);

        dealarRepo.save(dealar);

        return "data added verify this account";
    }

    @Override
    public String loginDealar(String mail, String password) {
        Dealar dealar = dealarRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        if (!dealar.getPassword().equals(password)){
            throw new RuntimeException("Password is Wrong");
        }
        if (dealar.getVerifyStatus().equals(false)){
            throw new RuntimeException("Dealar is not Verify Please Verify Dealer First");
        }
        return "Login Successfully";
    }

    @Override
    public String verifyDealer(String mail, Integer otp) {
        Dealar dealar = dealarRepo.findByMail(mail).orElseThrow(()->new RuntimeException("mail is not Present"));
        if (!dealar.getOtp().equals(otp)){
            throw new RuntimeException("Wrong otp");
        }
        dealar.setVerifyStatus(true);
        return "Account Verify";
    }

    @Override
    public Dealar displayDealerDetails(String mail) {
        Dealar dealar = dealarRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not present"));
        return dealar;
    }

    @Override
    public List<Dealar> dispayAllDealer() {
        List<Dealar> dealars = dealarRepo.findAll();
        return dealars;
    }

    @Override
    public String updateDealer(Dealar dealar, String mail) {
        Dealar dealar1 = dealarRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        dealar1.setFirstName(dealar.getFirstName());
        dealar1.setLastName(dealar.getLastName());
        return "Update Data";
    }

    @Override
    public String deleteDealer(String mail) {
        Dealar dealar = dealarRepo.findByMail(mail).orElseThrow(()->new RuntimeException("Mail is not Present"));
        dealarRepo.delete(dealar);
        return "Data Deleted";
    }
}
