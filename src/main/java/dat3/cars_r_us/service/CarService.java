package dat3.cars_r_us.service;

import dat3.cars_r_us.dto.CarRequest;
import dat3.cars_r_us.dto.CarResponse;
import dat3.cars_r_us.entity.Car;
import dat3.cars_r_us.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;


    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public CarResponse findCarById(int id, boolean allInfo) {
        Car found = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with id: " + id + " not found")) ;
        return new CarResponse(found, allInfo);
    }


    public List<CarResponse> findCars(boolean allInfo){
        List<Car> cars = (List<Car>) carRepository.findAll();
        List<CarResponse> carResponses =
                cars.stream().map(car -> new CarResponse(car, allInfo)).collect(Collectors.toList());

        return carResponses;
    }

    public CarResponse addCar(CarRequest carRequest){
        Car car = CarRequest.getCarEntity(carRequest);
        car = carRepository.save(car);
        return new CarResponse(car, false);
    }

    public void editCar(CarRequest body, int id){
        Car car = carRepository.findById(id).orElseThrow(
                ()->  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with id: " + id + ", already exist"));
        if(body.getId() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change car id");
        }
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setBestDiscount(body.isBestDiscount());

        carRepository.save(car);
    }

    public void deleteCar(int id){
        carRepository.deleteById(id);
    }

    public void setPricePrDay(int id, double new_price) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with id: " + id + " not found"));
        car.setPricePrDay(new_price);
        carRepository.save(car);
    }

    public void setBestDiscount(int id, boolean best_discount) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with id: " + id + " not found"));
        car.setBestDiscount(best_discount);
        carRepository.save(car);
    }
}


