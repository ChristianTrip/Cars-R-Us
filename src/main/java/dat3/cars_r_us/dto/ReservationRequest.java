package dat3.cars_r_us.dto;

import dat3.cars_r_us.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {


    private int carId;
    private String userName;
    private String rentalDate;


    public ReservationRequest(Reservation reservation){
        this.carId = reservation.getCar().getId();
        this.userName = reservation.getMember().getUsername();
        this.rentalDate = reservation.getRentalDate().toString();
    }

}
