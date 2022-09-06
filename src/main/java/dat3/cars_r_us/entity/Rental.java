package dat3.cars_r_us.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
//@Builder - kan kaldes for at bygge en custom constructor
public class Rental {

    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;
    private LocalDate rentalDate;
    private int pricePrDay;

    public Rental(LocalDate rentalDate, int pricePrDay) {
        this.rentalDate = rentalDate;
        this.pricePrDay = pricePrDay;
    }

    public Rental() {
    }


}
