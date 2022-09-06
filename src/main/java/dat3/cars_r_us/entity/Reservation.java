package dat3.cars_r_us.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;
    @CreationTimestamp
    private LocalDateTime reservationDate;
    private LocalDate rentalDate;

    public Reservation(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Reservation(){}


}
