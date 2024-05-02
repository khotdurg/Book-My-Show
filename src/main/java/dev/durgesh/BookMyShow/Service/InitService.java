package dev.durgesh.BookMyShow.Service;

import dev.durgesh.BookMyShow.Model.*;
import dev.durgesh.BookMyShow.Model.Constant.AuditoriumFeature;
import dev.durgesh.BookMyShow.Model.Constant.SeatStatus;
import dev.durgesh.BookMyShow.Model.Constant.SeatType;
import dev.durgesh.BookMyShow.Model.Constant.ShowSeatStatus;
import dev.durgesh.BookMyShow.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public boolean initialise(){
        City nagpur = new City("Nagpur");
        City bangalore = new City("Bangalore");
        City canberra = new City("Canberra");

        cityRepository.save(nagpur);
        cityRepository.save(bangalore);
        cityRepository.save(canberra);

        City savedNagpur = cityRepository.findCityByName("nagpur");
        Theatre dkMultiplex = new Theatre("DK Multiplex", "Aundh, Pune");
        Theatre khotImax = new Theatre("Khot IMAX", "Kasba peth, Pune");

        theatreRepository.save(dkMultiplex);
        theatreRepository.save(khotImax);

        Theatre savedDkmultiplex = theatreRepository.findTheatreByName("DK Multiplex");
        Theatre savedKhotImax = theatreRepository.findTheatreByName("Khot IMAX");

        List<Theatre> nagpurTheatres = new ArrayList<>();
        nagpurTheatres.add(savedDkmultiplex);
        nagpurTheatres.add(savedKhotImax);
        savedNagpur.setTheatres(nagpurTheatres);
        cityRepository.save(savedNagpur);

        for(int i=1;i<=5;i++){
            Seat s = new Seat(i, i, i+ " "+i, SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll(); // returns all the data of the table, "select * from table"

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

        Auditorium savedAudi = auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre savedTheatre = theatreRepository.findTheatreByName("DK Multiplex");
        List<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(savedAudi);
        savedTheatre.setAuditoriums(auditoriums);
        theatreRepository.save(savedTheatre);

        Movie movie = new Movie("Titanic", "best movie ever");
        movieRepository.save(movie);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        showRepository.save(show);

        for(int i=1;i<=5;i++){
            ShowSeat s = new ShowSeat(1251, showRepository.findById(1).get(), seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }
        return true;
    }
}
/*
        if(x == 4){
               x++;
        }else {
               x--;
        }

    ternary operator
    x==4   ?  x++ : x--

    Theatre Audi mapping not present


 */