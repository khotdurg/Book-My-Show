package dev.durgesh.BookMyShow.Service;

import dev.durgesh.BookMyShow.Model.City;
import dev.durgesh.BookMyShow.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService { // service is dependent on repository
    @Autowired //dependency automatically injected
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityByName(String cityName){
        City city = cityRepository.findCityByName(cityName);
        return city;
    }

    public City getCityById(int cityId){
        return cityRepository.findById(cityId).get();
    }


    //for add city
    public City saveCity(String cityName){ //this will create the city
        City city = new City();             // will save the city inside the database
        city.setName(cityName);             //and return back to the user
        return cityRepository.save(city);// once i have a city obj i must save it
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    // for delete city
    public boolean deleteCity(int cityId){
        cityRepository.deleteById(cityId); //we can delete by id and we can delete entire city entity
        //but we will use deleteById
        return true;
    }
}
