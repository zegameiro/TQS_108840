package deti.tqs.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import deti.tqs.backend.models.Bus;
import deti.tqs.backend.models.BusTrip;
import deti.tqs.backend.models.Reservation;
import deti.tqs.backend.models.Seat;
import deti.tqs.backend.services.BusService;
import deti.tqs.backend.services.BusTripService;
import deti.tqs.backend.services.ReservationFormValidator;
import deti.tqs.backend.services.ReservationService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/reservations")
public class ReservationController {
  
  private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private BusService busService;

  @Autowired
  private BusTripService busTripService;

  @Autowired
  private ReservationFormValidator reservationFormValidator;

  @PostMapping("/buy")
  public ResponseEntity<Reservation> buyReservation(@RequestBody Reservation reservation) {

    logger.info("Buying reservation for trip" + reservation.getIdBusTrip() + " and seat " + reservation.getSeat());

    if (!busTripService.tripExists(reservation.getIdBusTrip())) {
      logger.error("Could not find trip with id " + reservation.getIdBusTrip());
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found!");
    }

    if (!reservationFormValidator.validateEmail(reservation.getEmail())) {
      logger.error("Invalid email format");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email format!");
    }

    if (!reservationFormValidator.validatePhone(reservation.getPhone())) {
      logger.error("Invalid phone format");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid phone format!");
    }

    BusTrip busTrip = busTripService.getBusTripById(reservation.getIdBusTrip(), "EUR");

    if (busTrip == null) {
      logger.error("Could not find trip with id " + reservation.getIdBusTrip());
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found!");
    }

    int requestedSeat = reservation.getSeat() - Integer.parseInt(busTrip.getSeats().get(0).toString());

    if (requestedSeat < 1 || requestedSeat > busTrip.getSeats().size()) {
      logger.error("Invalid seat number");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid seat number!");
    }

    reservation.setSeat(requestedSeat + 1);

    Bus tripBus = busService.getBusById(busTrip.getBusId());

    int lastTicketBus = Integer.parseInt(busTrip.getSeats().get(0).toString()) + busTrip.getSeats().size();
    int givenSeat = reservation.getSeat();

    if (givenSeat < lastTicketBus || givenSeat < 0) {
      logger.error("Invalid seat number");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid seat number!");
    }

    List<Seat> seats = busTrip.getSeats();

    Seat seat = seats.get(givenSeat);

    if (seat.getIsTaken()) {
      logger.error("Seat already taken");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat already taken!");
    }

    int seatsTaken = 0;

    for(Seat s: seats) {
      if (s.getIsTaken())
        seatsTaken++;
    }

    if (seatsTaken >= tripBus.getCapacity()) {
      logger.error("Bus is full");
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bus is full!");
    }

    Reservation r = reservationService.buyReservation(reservation);

    return ResponseEntity.ok(r);
  }

  @GetMapping("/list")
  public ResponseEntity<List<Reservation>> listReservations() {
    List<Reservation> reservations = reservationService.findAllTickets();
    logger.info("List of reservations requested");
    return ResponseEntity.ok(reservations);
  }
}
