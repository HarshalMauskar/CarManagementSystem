package com.carService.carService.Controller;

import com.carService.carService.DTO.DealarDto;
import com.carService.carService.Interface.IDealar;
import com.carService.carService.Model.Dealar;
import com.carService.carService.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DealerController {
    @Autowired
    private IDealar iDealer;

    @PostMapping("/signupDealer")
    public ResponseEntity<?> signupDealer(@RequestBody DealarDto dealarDto){
        try {
            String message =iDealer.signupDealer(dealarDto);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/loginDealar")
    public ResponseEntity<?> loginDealar(@RequestParam String mail, @RequestParam String password){
        try {
            String message = iDealer.loginDealar(mail,password);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/verifyDealar")
    public ResponseEntity<?> VerifyDealer(@RequestParam String mail, @RequestParam Integer otp){
        try{
            String message = iDealer.verifyDealer(mail,otp);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/displayDealerDetails")
    public ResponseEntity<?> displayDealerDetails(@RequestParam String mail){
        try {
            Dealar message = iDealer.displayDealerDetails(mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/displayAllDealer")
    public ResponseEntity<?> displayAllDealer(){
        List<Dealar> dealers = iDealer.dispayAllDealer();
        return (ResponseEntity<?>) dealers;
    }
    @PutMapping("/updateDealer")
    public ResponseEntity<?> updateDealer(@RequestBody Dealar dealar, @RequestParam String mail){
        try {
            String message = iDealer.updateDealer(dealar,mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteDealer")
    public ResponseEntity<?> deleteDealer(@RequestParam String mail){
        try {
            String message = iDealer.deleteDealer(mail);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
