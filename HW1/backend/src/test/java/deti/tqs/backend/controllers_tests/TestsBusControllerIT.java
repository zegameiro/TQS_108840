package deti.tqs.backend.controllers_tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import deti.tqs.backend.models.Bus;
import deti.tqs.backend.repositories.BusRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.profiles.active=test")
@AutoConfigureTestDatabase
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsBusControllerIT {
  
  @LocalServerPort
  int randomServerPort;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private BusRepository busRepository;

  @Test
  @DisplayName("Test create a new bus")
  public void testCreateBus() {
    Bus bus = new Bus();
    bus.setName("Flix Bus 1");
    bus.setCapacity(74);

    ResponseEntity<Bus> response = restTemplate.postForEntity("/api/bus/add", bus, Bus.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().getName()).isEqualTo("Flix Bus 1");
    assertThat(response.getBody().getCapacity()).isEqualTo(74);
  }

  @Test
  @DisplayName("Test get a bus by id and return the correrct bus")
  public void testGetBusById() {
    Bus bus = new Bus();
    bus.setName("Flix Bus 2");
    bus.setCapacity(74);
    busRepository.save(bus);

    ResponseEntity<Bus> response = restTemplate.getForEntity("/api/bus/get?id=" + bus.getId(), Bus.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().getName()).isEqualTo("Flix Bus 2");
    assertThat(response.getBody().getCapacity()).isEqualTo(74);
  }

  @Test
  @DisplayName("Test get all buses and return the correct buses")
  public void testGetAllBuses() {
    Bus bus1 = new Bus();
    bus1.setName("Flix Bus 3");
    bus1.setCapacity(74);
    busRepository.save(bus1);

    Bus bus2 = new Bus();
    bus2.setName("Flix Bus 4");
    bus2.setCapacity(74);
    busRepository.save(bus2);

    ResponseEntity<Bus[]> response = restTemplate.getForEntity("/api/bus/getAll", Bus[].class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().length).isEqualTo(2);
    assertThat(response.getBody()[0].getName()).isEqualTo("Flix Bus 3");
    assertThat(response.getBody()[0].getCapacity()).isEqualTo(74);
    assertThat(response.getBody()[1].getName()).isEqualTo("Flix Bus 4");
    assertThat(response.getBody()[1].getCapacity()).isEqualTo(74);
  }

  @Test
  @DisplayName("Test get a bus by id and return not found")
  public void testGetBusByIdNotFound() {
    ResponseEntity<Bus> response = restTemplate.getForEntity("/api/bus/get?id=1", Bus.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

}
