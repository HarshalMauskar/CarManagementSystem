package com.carService.carService.Repo;

import com.carService.carService.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer>{
    @Query(value = "select * from car.car_info where mail = :mail",nativeQuery = true)
    Optional<Car> findByMail(@Param("mail") String mail);
}
