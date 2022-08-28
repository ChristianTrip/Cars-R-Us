package dat3.cars_r_us.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand", nullable = true)
    private String brand;
    @Column(name = "model", nullable = true)
    private String model;
    @Column(name = "pris_pr_dag", nullable = true)
    private int pricePrDay;
    @Column(name = "best_discount", nullable = true)
    private boolean bestDiscount;

    public Car(String brand, String model, int pricePrDay, boolean bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public Car() {
    }
}
