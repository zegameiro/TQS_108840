package deti.tqs.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deti.tqs.backend.models.City;
import deti.tqs.backend.models.Type;
import deti.tqs.backend.repositories.CityRepository;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public void saveCity(City city) {
    cityRepository.save(city);
  }

  public City findById(long id) {
    return cityRepository.findById(id);
  }

  public List<City> findByType(Type type) {
    return cityRepository.findByType(type);
  }
}
