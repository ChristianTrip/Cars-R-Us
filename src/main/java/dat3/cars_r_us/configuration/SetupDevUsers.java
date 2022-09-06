package dat3.cars_r_us.configuration;

import dat3.cars_r_us.entity.Car;
import dat3.cars_r_us.entity.Member;
import dat3.cars_r_us.repository.CarRepository;
import dat3.cars_r_us.repository.MemberRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    MemberRepository memberRepository;
    CarRepository carRepository;

    String passwordUsedByAll;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository,
                         MemberRepository memberRepository,
                         CarRepository carRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
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

        Car car1 = new Car("Testa", "Model 1", 1000, false);
        carRepository.save(car1);


    }
}
