package dev.durgesh.BookMyShow.Service;

import dev.durgesh.BookMyShow.Model.City;
import dev.durgesh.BookMyShow.Model.Theatre;
import dev.durgesh.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRespository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        //now I will save the theatre
        Theatre savedTheatre = theatreRespository.save(theatre);

        //now need to map this theatre to thr city
        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return savedTheatre;
    }

}
