package dat3.cars_r_us.repository;

import dat3.cars_r_us.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
