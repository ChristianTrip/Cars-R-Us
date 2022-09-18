package dat3.cars_r_us.repository;

import dat3.cars_r_us.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


    boolean existsByCar_IdAndRentalDate(int id, LocalDate date);
}
