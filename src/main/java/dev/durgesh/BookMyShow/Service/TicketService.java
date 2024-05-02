package dev.durgesh.BookMyShow.Service;

import dev.durgesh.BookMyShow.Model.Constant.ShowSeatStatus;
import dev.durgesh.BookMyShow.Model.ShowSeat;
import dev.durgesh.BookMyShow.Model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        // checking if the selected seats are available
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available anymore");
            }
        }

        //one day for loop completes and not thrown any exception, we should lock the seats
        // updating the seats to a locked state
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED); //after that save it go to showSeatService
            showSeatService.saveShowSeat(seat);
        }
        //write the logic for payment flow
        startPayment(showSeatIds);
        return new Ticket();
    }

    public boolean startPayment(List<Integer> showSeatIds){
        return true;
    }


    public String greet(){
        return "HELLOWORLD";
    }
}
