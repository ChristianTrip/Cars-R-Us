package dat3.cars_r_us.configuration;

import dat3.cars_r_us.entity.Car;
import dat3.cars_r_us.entity.Member;
import dat3.cars_r_us.entity.Reservation;
import dat3.cars_r_us.repository.CarRepository;
import dat3.cars_r_us.repository.MemberRepository;
import dat3.cars_r_us.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    private UserWithRolesRepository userWithRolesRepository;
    private MemberRepository memberRepository;
    private CarRepository carRepository;

    private ReservationRepository reservationRepository;

    private String passwordUsedByAll;


    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository,
                         MemberRepository memberRepository,
                         CarRepository carRepository,
                         ReservationRepository reservationRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        //setupUserWithRoleUsers();
        setup();
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/

    private void setup() {
        System.out.println("******************************************************************************");
        System.out.println("******* SETTING UP MEMBERS, CARS, RESERVATIONS FOR TESTING PURPOSES **********");
        System.out.println("*** THIS IS INSTEAD OF USING THE USER-WITH-ROLES CLASS THAT CAUSES PROBLEMS **");
        System.out.println("*************** AT LEAST FOR NOW *********************************************");
        System.out.println("******************************************************************************");

        Member user1 = new Member("user1", "Password1234", "lenny@mail.dk", "Lenny", "Krawitz", "Ålandsgade 8", "København S", "2300");
        Member user2 = new Member("user2", "Password1234", "brian@mail.dk", "Brian", "Griffin", "Vestparken 3", "Oksbøl", "6840");
        Member user3 = new Member("user3", "Password1234", "emil@mail.dk", "Emil", "Lauritz", "Jegumvej 10", "Jegum", "6840");
        Member user4 = new Member("user4", "Password1234", "alice@mail.dk", "Alice", "Madsen", "Mjøsensgade 8", "København S", "2300");
        Member user5 = new Member("user5", "Password1234", "trip@mail.dk", "Christian", "Trip", "Holmbladsgade 80", "København S", "2300");
        Member user6 = new Member("user6", "Password1234", "hank@mail.dk", "Hank", "Williams", "Vestparken 61", "Oksbøl", "6840");
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        user4.addRole(Role.ADMIN);
        user5.addRole(Role.USER);
        user6.addRole(Role.USER);
        memberRepository.save(user1);
        memberRepository.save(user2);
        memberRepository.save(user3);
        memberRepository.save(user4);
        memberRepository.save(user5);
        memberRepository.save(user6);

        Car car1 = new Car("Tesla", "Model 1", 1000, false);
        Car car2 = new Car("Mazda", "DX-1", 2000, true);
        Car car3 = new Car("Skoda", "Octavia", 500, false);
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        Reservation reservation1 = new Reservation(user2, car1, LocalDate.now());
        Reservation reservation2 = new Reservation(user3, car3, LocalDate.now());
        //reservationRepository.save(reservation1);

    }

/*
    private void setupUserWithRoleUsers() {
        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        user4.addRole(Role.ADMIN);
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);

        Member member1 = new Member("user5", "Password1234", "trip@mail.dk", "Christian", "Trip", "Holmbladsgade 80", "København S", "2300");
        Member member2 = new Member("user6", "Password1234", "hank@mail.dk", "Hank", "Williams", "Vestparken 61", "Oksbøl", "6840");
        member1.addRole(Role.USER);
        member2.addRole(Role.USER);
        memberRepository.save(member1);
        memberRepository.save(member2);

        Car car1 = new Car("Tesla", "Model 1", 1000, false);
        carRepository.save(car1);

        Reservation reservation = new Reservation(member1, car1, LocalDate.now());
        reservationRepository.save(reservation);

    }
*/

}
