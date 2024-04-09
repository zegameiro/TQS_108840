package deti.tqs.backend.services_tests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import deti.tqs.backend.models.BusTrip;
import deti.tqs.backend.repositories.BusTripRepository;
import deti.tqs.backend.services.BusTripService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TestBustripService {
  
  @Mock
  private BusTripRepository busTripRepository;

  @InjectMocks
  private BusTripService busTripService;

  @Test
  @DisplayName("Check get all existing bus trips")
  public void checkGetAllBusTrips() {
    BusTrip busTrip1 = new BusTrip();
    BusTrip busTrip2 = new BusTrip();
    BusTrip busTrip3 = new BusTrip();

    when(busTripRepository.findAll()).thenReturn(List.of(busTrip1, busTrip2, busTrip3));
    
    assertThat(busTripService.listTrips()).isEqualTo(List.of(busTrip1, busTrip2, busTrip3)).hasSize(3);

    verify(busTripRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Check get all dates of all bus trips")
  public void checkGetAllDates() {

    when(busTripRepository.findDates()).thenReturn(List.of("2011-12-23", "2000-11-12", "2021-06-03"));
    
    assertThat(busTripService.getDates()).isEqualTo(List.of("2011-12-23", "2000-11-12", "2021-06-03")).hasSize(3);

    verify(busTripRepository, times(1)).findDates();
  }

  @Test
  @DisplayName("Check get all from cities of all bus trips")
  public void checkGetAllFromCities() {

    when(busTripRepository.findFromCities()).thenReturn(List.of("Lisboa", "Pombal", "Leiria", "Aveiro"));
    
    assertThat(busTripService.getFromCities()).isEqualTo(List.of("Lisboa", "Pombal", "Leiria", "Aveiro")).hasSize(4);

    verify(busTripRepository, times(1)).findFromCities();
  }

  @Test
  @DisplayName("Check get all to cities of all bus trips")
  public void checkGetAllToCities() {

    when(busTripRepository.findToCities()).thenReturn(List.of("Lisboa", "Pombal", "Leiria", "Aveiro", "Porto", "Coimbra"));
    
    assertThat(busTripService.getToCities()).isEqualTo(List.of("Lisboa", "Pombal", "Leiria", "Aveiro", "Porto", "Coimbra")).hasSize(6);

    verify(busTripRepository, times(1)).findToCities();
  }
}
