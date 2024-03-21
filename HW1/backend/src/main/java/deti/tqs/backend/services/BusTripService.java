package deti.tqs.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deti.tqs.backend.models.BusTrip;
import deti.tqs.backend.repositories.BusTripRepository;

@Service
public class BusTripService {
  
  @Autowired
  private BusTripRepository busTripRepository;

  public void saveBusTrip(BusTrip busTrip) {
    busTripRepository.save(busTrip);
  }

  public BusTrip findById(long id) {
    return busTripRepository.findById(id);
  }

  public List<BusTrip> findByIdFromCity(long idFromCity) {
    return busTripRepository.findByIdFromCity(idFromCity);
  }
}
