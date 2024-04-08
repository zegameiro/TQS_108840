package deti.tqs.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import deti.tqs.backend.models.Reservation;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

  public Reservation findById(long id);

  public List<Reservation> findByIdBusTrip(int idBusTrip);

  public Reservation findBySeatAndIdBusTrip(int seatNumber, int idBusTrip);

  public List<Reservation> findAll();

}
