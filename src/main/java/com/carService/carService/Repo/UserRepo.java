package com.carService.carService.Repo;

import com.carService.carService.Model.Dealar;
import com.carService.carService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

     @Query(value = "select * from car.user_info; where mail = :mail",nativeQuery = true)
     Optional<User> findByMail(@Param("mail") String mail);
}
