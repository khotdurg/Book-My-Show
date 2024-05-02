package dev.durgesh.BookMyShow.Controller;

import dev.durgesh.BookMyShow.Service.TheatreService;
import dev.durgesh.BookMyShow.dto.TheatreRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO){
        return ResponseEntity.ok(
                theatreService.saveTheatre(
                        theatreRequestDTO.getName(),
                        theatreRequestDTO.getAddress(),
                        theatreRequestDTO.getCityId()
                )
        );
    }
}