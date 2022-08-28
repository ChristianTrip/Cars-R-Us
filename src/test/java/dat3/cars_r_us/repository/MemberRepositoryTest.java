package dat3.cars_r_us.repository;

import dat3.cars_r_us.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @BeforeAll
    public static void setupData(@Autowired MemberRepository memberRepository){

        Member member1 = new Member("aa", "bb", "a@mail.dk", "cc");
        Member member2 = new Member("dd", "ee", "d@mail.dk", "ff");

        memberRepository.save(member1);
        memberRepository.save(member2);
    }

    @Test
    void testFindById(){

        Member found = memberRepository.findById("aa").get();
        assertEquals("cc", found.getFirstName());

        found = memberRepository.findById("dd").get();
        assertEquals("ff", found.getFirstName());

    }

    @Test
    void testFindByEmail(){

    }


}