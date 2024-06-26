package org.java.springfinal.controller;

import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.Car;
import org.java.springfinal.model.User;
import org.java.springfinal.service.CarService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCarList() {
        return carService.getCarList();
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable Long id){
        return carService.getCar(id);
    }

    @PostMapping("/addcar")
    public String addCar(@RequestBody Car car) {
        System.out.println(car);
        return carService.addCar(car);
    }

    @GetMapping("/deletecar/{id}")
    public String deleteCar(@PathVariable Long id) {
        return carService.deleteCar(id);
    }

    @PostMapping("/updatecar/{id}")
    public String updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

//    @PostMapping("/buycar/{id}")
//    public String buyCar(@PathVariable Long id) {
//        return carService.buyCar(id);
//    }

    @GetMapping("/buy/{carId}")
    public String buyCar(@AuthenticationPrincipal User user, @PathVariable Long carId){
        return carService.buyCar(user.getId(), carId);
    }


}
