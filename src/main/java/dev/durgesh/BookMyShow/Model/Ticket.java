package dev.durgesh.BookMyShow.Model;

import dev.durgesh.BookMyShow.Model.Constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double totalAmount;

    @OneToMany  // 1 ticket can have mult showSeats
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
/*
        Ticket      Show
        1           1
        M           1
 */