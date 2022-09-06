package dat3.cars_r_us.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand", nullable = true)
    private String brand;
    @Column(name = "model", nullable = true)
    private String model;
    @Column(name = "price_pr_day", nullable = true)
    private double pricePrDay;
    @Column(name = "best_discount", nullable = true)
    private boolean bestDiscount;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rental> rentals = new ArrayList<>();

    public Car(String brand, String model, double pricePrDay, boolean bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public Car() {
    }

    public void addRental(Rental rental){
        this.rentals.add(rental);
        rental.setCar(this);
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
        reservation.setCar(this);
    }
}
