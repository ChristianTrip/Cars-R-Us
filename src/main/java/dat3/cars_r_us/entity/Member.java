package dat3.cars_r_us.entity;

import dat3.security.entity.UserWithRoles;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Member extends UserWithRoles{

    @Column(length = 30)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String street;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String zip;

    private boolean approved;
    private int ranking;


    public Member(String user, String password, String email, String firstName){
        super(user, password, email);
        this.firstName = firstName;
    }

    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Member() {
    }


}
