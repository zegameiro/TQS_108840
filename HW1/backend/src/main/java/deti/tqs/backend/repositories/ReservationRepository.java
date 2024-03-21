package deti.tqs.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import deti.tqs.backend.models.Reservation;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
  
  public List<Reservation> findAll();

  public Reservation findById(long id);

}
