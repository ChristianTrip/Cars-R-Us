package dat3.cars_r_us.repository;

import dat3.cars_r_us.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
