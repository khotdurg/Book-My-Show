package dev.durgesh.BookMyShow.Model;

import dev.durgesh.BookMyShow.Model.Constant.SeatStatus;
import dev.durgesh.BookMyShow.Model.Constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // need table
public class Seat extends BaseModel{
    private int row;
    private int col;
    private String seatNumber;

    @Enumerated(EnumType.STRING) // not collection used because seat type is singular
    private SeatType seatType;

    @Enumerated(EnumType.STRING) // not collection used because seat status is singular
    private SeatStatus seatStatus;


    public Seat(){

    }

    public Seat(int row, int col, String seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.row = row;
        this.col = col;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }




}
