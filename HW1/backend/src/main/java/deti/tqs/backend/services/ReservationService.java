package deti.tqs.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deti.tqs.backend.models.Reservation;
import deti.tqs.backend.repositories.ReservationRepository;

@Service
public class ReservationService {
  
  @Autowired
  private ReservationRepository reservationRepository;

  public void saveReservation(Reservation reservation) {
    reservationRepository.save(reservation);
  }

  public List<Reservation> findAll() {
    return reservationRepository.findAll();
  }

  public Reservation findById(long id) {
    return reservationRepository.findById(id);
  }
}
