package deti.tqs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    reservation.setId();
    reservationService.saveReservation(reservation);
    return "Reservation added";
  }

  @PostMapping("/confirmReservation")
  public @ResponseBody String confirmReservation(@RequestParam long id) {
    Reservation reservation = reservationService.findById(id);

    if (reservation == null) 
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Reservation not found");

    reservation.setIsPaid(true);

    return "OK";
  }

  @DeleteMapping("/cancelReservation")
  public @ResponseBody String cancelReservation(@RequestParam long id) {
    Reservation reservation = reservationService.findById(id);

    if (reservation == null)
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Reservation not found");

    reservationService.deleteReservation(reservation);

    return "OK";
  }
}
