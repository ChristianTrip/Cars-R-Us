package dat3.cars_r_us.dto;

import dat3.cars_r_us.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {

    private int id;
    private String brand;
    private String model;
    private double pricePrDay;
    private boolean bestDiscount;

    public CarRequest(Car car){
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.bestDiscount = car.isBestDiscount();
    }

    public static Car getCarEntity(CarRequest request){
        return new Car(request.getBrand(), request.getModel(), request.getPricePrDay(), request.isBestDiscount());
    }

}
