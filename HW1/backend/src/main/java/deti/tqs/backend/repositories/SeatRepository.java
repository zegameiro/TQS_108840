package deti.tqs.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import deti.tqs.backend.models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
  
  public Seat findById(int id);
}
