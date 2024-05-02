package dev.durgesh.BookMyShow.Model;

import dev.durgesh.BookMyShow.Model.Constant.PaymentMode;
import dev.durgesh.BookMyShow.Model.Constant.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity //need table
public class Payment extends BaseModel{
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;

    @ManyToOne // mult payment(Upi + wallet etc) can have one ticket
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

}
