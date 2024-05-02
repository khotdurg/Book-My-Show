package dev.durgesh.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity  //(name ="Actor") //if we do not write this our class name become table name
//it says that this class should need a table
public class Actor extends BaseModel{ // for this actor I want to create a table, the moment i will
    // create a table it known as entity
    private String name; //similarly this name become col name if we want to give (name ="ACTOR_NAME")
    // if we dont write this the attribute name become col name
    //if we create a table we must need a primary key

    @ManyToMany
    private List<Movie> movies;
}