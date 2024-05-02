package dev.durgesh.BookMyShow.Model;

import dev.durgesh.BookMyShow.Model.Constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // i want table
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany // 1 audi can have multiple shows
    private List<Show> shows;
    @OneToMany // 1 audi can have multiple seats
    private List<Seat> seats;

    @ElementCollection // used when enum is mul data structure ex. list, set etc
    @Enumerated(EnumType.STRING) // creates relationship betn entity class and enum in db
    private List<AuditoriumFeature> auditoriumFeatures; //i want table this is multiple entity bcz of list
}
