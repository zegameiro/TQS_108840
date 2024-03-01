package deti;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import deti.tqs.boundary.CarController;
import deti.tqs.services.CarManagerService;
import deti.tqs.model.Car;

@WebMvcTest(CarController.class)
public class CarsControllerTests {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    @Test
    void whenPostCar_thenCreateEmployee() throws Exception {
        Car car1 = new Car("Tesla", "X");

        when(service.save(Mockito.any())).thenReturn(car1);

        mvc.perform(
          post("/api/cars")
          .contentType(MediaType.APPLICATION_JSON)
          .content(JsonUtils.toJson(car1))
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.maker", is(car1.getMaker())))
          .andExpect(jsonPath("$.model", is(car1.getModel())))
        );

        verify(service, times(1)).save(Mockito.any());
    }
}
