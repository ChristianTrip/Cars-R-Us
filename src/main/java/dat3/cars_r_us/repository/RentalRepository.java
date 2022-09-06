package dat3.cars_r_us.repository;

import dat3.cars_r_us.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
