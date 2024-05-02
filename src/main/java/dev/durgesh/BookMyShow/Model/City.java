package dev.durgesh.BookMyShow.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

import java.util.List;

@Getter
@Setter
@Entity// i want city table
//@Table("city")
public class City extends BaseModel{

    public City(){
    }

    public City(String name){
        this.name = name;
    }

    //@Column("name")

    private String name;
    @OneToMany // cardinality between city and theatre
    private List<Theatre> theatres;

}
