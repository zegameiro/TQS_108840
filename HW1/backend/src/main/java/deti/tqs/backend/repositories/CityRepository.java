package deti.tqs.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import deti.tqs.backend.models.City;
import deti.tqs.backend.models.Type;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
  
  public List<City> findAll();

  public City findById(long id);

  public List<City> findByName(String name);

  public List<City> findByType(Type type);
}

