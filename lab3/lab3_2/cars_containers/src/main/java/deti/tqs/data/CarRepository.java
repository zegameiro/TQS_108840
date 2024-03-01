package deti.tqs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import deti.tqs.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findByCarId(Long carId);

    public List<Car> findAll();

}

