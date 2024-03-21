package deti.tqs.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import deti.tqs.backend.models.BusTrip;

@Repository
public interface BusTripRepository extends CrudRepository<BusTrip, Long>{
  
  public List<BusTrip> findAll();

  public BusTrip findById(long id);

  public List<BusTrip> findByIdFromCity(long idFromCity);

  public List<BusTrip> findByIdToCity(long idToCity);

  public List<BusTrip> findByIdFromCityAndIdToCity(long idFromCity, long idToCity);
  
}
