package deti.tqs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deti.tqs.backend.models.Reservation;
import deti.tqs.backend.services.ReservationService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/reservation")
public class ReservationController {
  
  @Autowired
  private ReservationService reservationService;

  @PostMapping("/addReservation")
  public String addReservation(@RequestBody Reservation reservation) {

    

    return "Reservation added";
  }
}
