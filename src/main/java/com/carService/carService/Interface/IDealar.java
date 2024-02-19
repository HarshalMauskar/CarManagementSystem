package com.carService.carService.Interface;

import com.carService.carService.DTO.DealarDto;
import com.carService.carService.Model.Dealar;

import java.util.List;

public interface IDealar {
    String signupDealer(DealarDto dealarDto);

    String loginDealar(String mail, String password);

    String verifyDealer(String mail, Integer otp);

    Dealar displayDealerDetails(String mail);

    List<Dealar> dispayAllDealer();

    String updateDealer(Dealar dealar, String mail);

    String deleteDealer(String mail);
}
