package dat3.cars_r_us.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars_r_us.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    private int id;
    private String brand;
    private String model;
    private double pricePrDay;
    private boolean bestDiscount;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime edited;

   public CarResponse(Car car, boolean includeAll){
       this.id = car.getId();
       this.brand = car.getBrand();
       this.model = car.getModel();
       this.pricePrDay = car.getPricePrDay();
       this.bestDiscount = car.isBestDiscount();
       if(includeAll){
           this.created = car.getCreated();
           this.edited = car.getEdited();
       }
   }
}
