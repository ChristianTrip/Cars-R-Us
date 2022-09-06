package dat3.cars_r_us.api;

import dat3.cars_r_us.dto.CarRequest;
import dat3.cars_r_us.dto.CarResponse;
import dat3.cars_r_us.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Security USER
    //----------------------------------------------------

    @GetMapping("/{id}")
    public CarResponse getCarById(@RequestParam(value = "id") int id){
        return carService.findCarById(id, false);
    }


    //Security ADMIN
    //----------------------------------------------------

    @GetMapping("/admin/all")
    public List<CarResponse> getAllCars(){
        return carService.findCars(false);
    }

    @GetMapping("/admin")
    public List<CarResponse> getCarsWithAllInfo() {
        return carService.findCars(true);
    }

    @GetMapping(path = "/admin/{id}")
    public CarResponse getCarByIdWithAllInfo(@PathVariable(value = "id") int id) throws Exception {
        CarResponse response = carService.findCarById(id, true);
        return response;
    }

    @PostMapping("/admin")
    public CarResponse addCar(@RequestBody CarRequest car){
        return carService.addCar(car);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Boolean> editCar(@RequestBody CarRequest car, @PathVariable(value = "id") int id){
        carService.editCar(car, id);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @PatchMapping("/admin/rentalprice/{id}/{new_price}")
    public void setNewPrice(@PathVariable(value = "id") int id, @PathVariable double new_price) {
        carService.setPricePrDay(id, new_price);
    }

    @PatchMapping("/admin/bestdiscount/{id}/{best_discount}")
    public void setBestDiscount(@PathVariable(value = "id") int id, @PathVariable boolean best_discount){
        carService.setBestDiscount(id, best_discount);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteCar(@PathVariable(value = "id") int id){
        carService.deleteCar(id);
    }

}
