package dat3.cars_r_us.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars_r_us.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    private int id;
    private String memberUsername;
    private int carId;
    private String carBrand;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate rentalDate;


    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.memberUsername = reservation.getMember().getUsername();
        this.carId = reservation.getCar().getId();
        this.carBrand = reservation.getCar().getBrand();
    }
}
