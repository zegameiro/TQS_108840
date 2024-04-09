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
}
