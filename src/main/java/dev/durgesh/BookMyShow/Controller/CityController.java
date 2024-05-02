package dev.durgesh.BookMyShow.Controller;

import dev.durgesh.BookMyShow.Model.City;
import dev.durgesh.BookMyShow.Service.CityService;
import dev.durgesh.BookMyShow.dto.CityRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService; // Controller depend on service

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City savedCity = cityService.getCityByName(cityName);
        return ResponseEntity.ok(savedCity);  // we would return cityResponseDTO
    }

    @GetMapping("/city")
    public ResponseEntity getAllCities(){
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);  // we would return cityResponseDTO
    }

    //add city
    //we want to add a new city
    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){ //client should send me request to create data
        //when we want to respond back from the user we get
        // 2 things 1. response 2. http status code that called ResponseEntity

        try{
            String cityName = cityRequestDTO.getName();
            if(cityName==null || cityName.length()==0 || cityName.isEmpty() || cityName.isBlank()){
                throw new Exception("City Name is invalid");
            }
            City saveCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(saveCity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Delete city
    @DeleteMapping("/city/{id}") // we dont need an entire object(city object) now just id will be ok. id is a part of url/path
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}


