package dev.durgesh.BookMyShow.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // i want table
public class Theatre extends BaseModel{
    private String name;
    private String address;

    public Theatre(){

    }

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany //Cardinality between theatre and auditorium
    private List<Auditorium> auditoriums;

}
