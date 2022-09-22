package dat3.cars_r_us.service;

import dat3.cars_r_us.dto.CarResponse;
import dat3.cars_r_us.entity.Car;
import dat3.cars_r_us.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {


    @Mock
    CarRepository carRepository;
    @Autowired
    CarService carService;


    @BeforeEach
    public void setup(){
        carService = new CarService(carRepository);
    }

    @Test
    void getCar(){
        Mockito.when(carRepository.findAll()).thenReturn(List.of(
                new Car("Tesla", "Model 1", 1000, false),
                new Car("Mazda", "MX-3", 2000, true)
        ));

        List<CarResponse> cars = carService.findCars(false);
        assertEquals(2, cars.size());
    }

}
