package dev.durgesh.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatsIds;
    private Integer userId;
}
