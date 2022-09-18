package dat3.cars_r_us.api;

import dat3.cars_r_us.dto.ReservationResponse;
import dat3.cars_r_us.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/{username}/{car_id}/{rental_date}")
    public void addReservation(@PathVariable String username, @PathVariable int car_id, @PathVariable String rental_date){
        System.out.println("- User name   : " + username);
        System.out.println("- Car id      : " + car_id);
        System.out.println("- Rental date : " + rental_date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(rental_date,formatter);
        System.out.println("formatted date: " + date);
        reservationService.reserveCar(username, car_id, date);
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservationById(@PathVariable int id){
        ReservationResponse response = reservationService.getReservationById(id);
        return response;
    }

    @GetMapping("/all")
    public List<ReservationResponse> getAllReservations(){


        return reservationService.getAllReservations();
    }

}
