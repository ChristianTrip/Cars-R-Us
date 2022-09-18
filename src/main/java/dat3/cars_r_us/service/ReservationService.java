package dat3.cars_r_us.service;

import dat3.cars_r_us.dto.ReservationResponse;
import dat3.cars_r_us.entity.Car;
import dat3.cars_r_us.entity.Member;
import dat3.cars_r_us.entity.Reservation;
import dat3.cars_r_us.repository.CarRepository;
import dat3.cars_r_us.repository.MemberRepository;
import dat3.cars_r_us.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;
    private CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    public Car getCarById(int carId){

        Car car = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
        return car;
    }

    public Member getMember(String userName){
        Member member = memberRepository.findById(userName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return member;
    }

    public Reservation reserveCar(String userName, int carId, LocalDate date){
        Member member = memberRepository.findById(userName).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));
        Reservation reservation;

        boolean reservationExist = reservationRepository.existsByCar_IdAndRentalDate(carId, date);

        if (!reservationExist){
            reservation = new Reservation(member, car, date);
            reservationRepository.save(reservation);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car reserved for this date");
        }

        return reservation;
    }

    public ReservationResponse getReservationById(int id) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return new ReservationResponse(reservation);
    }

    public List<ReservationResponse> getAllReservations(){
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        List<ReservationResponse> reservationResponses =
                reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
        return reservationResponses;
    }
}
