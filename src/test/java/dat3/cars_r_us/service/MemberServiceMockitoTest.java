package dat3.cars_r_us.service;

import dat3.cars_r_us.dto.MemberRequest;
import dat3.cars_r_us.dto.MemberResponse;
import dat3.cars_r_us.entity.Member;
import dat3.cars_r_us.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MemberServiceMockitoTest {

    @Mock
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @BeforeEach
    public void setup() {
        memberService = new MemberService(memberRepository);
    }

    @Test
    void editMember() {
    }

    @Test
    void getMembers() {
        Mockito.when(memberRepository.findAll()).thenReturn(List.of(
                new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234"),
                new Member("m2", "pw", "mm@a.dk", "bb", "bbb", "bbbb", "bbbb", "1234")
        ));
        List<MemberResponse> members = memberService.findMembers();
        assertEquals(2, members.size());
    }



    @Test
    void findMemberByUsername() {
    }

    @Test
    void setRankingForUser() {
    }

    @Test
    void deleteByUsername() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void addMember() throws Exception {
        Member m = new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234");
        //If you wan't to do this for Car you have to manually set the id. REMEMBER there is NO real database
        Mockito.when(memberRepository.save(any(Member.class))).thenReturn(m);
        MemberRequest request = new MemberRequest(m);
        MemberResponse found = memberService.addMember(request);
        assertEquals("m1", found.getUsername());
    }

}