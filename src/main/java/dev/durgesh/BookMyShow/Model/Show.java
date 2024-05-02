package dev.durgesh.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // want table
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne // mult show will run 1 movie, but 1 show cant run many movie
    private Movie movie;

    @ManyToOne //1 show(DDLJ) cnt have many audi but many show(DDLJ) will run in single audi
    private Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeat;
}
