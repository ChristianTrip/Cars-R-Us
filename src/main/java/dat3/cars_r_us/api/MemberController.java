package dat3.cars_r_us.api;

import dat3.cars_r_us.dto.MemberResponse;
import dat3.cars_r_us.dto.MemberRequest;
import dat3.cars_r_us.entity.Member;
import dat3.cars_r_us.repository.MemberRepository;
import dat3.cars_r_us.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    MemberService memberService;
    MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }


    @GetMapping("/all")
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    // Security ADMIN
    @GetMapping
    public List<MemberResponse> getMembers(){
        return memberService.findMembers();
    }

    // Security ADMIN
    @GetMapping(path = "/{username}")
    public MemberResponse getMemberById(@PathVariable String username) throws Exception{

        System.out.println("jsfhddfgdgd" + username);
        return memberService.findMemberByUsername(username);
    }

    // kommer ind som JSON
    // Security -> USER
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }



    @PutMapping(path = "/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String userName){
        return null;
    }

    @DeleteMapping("/{username}")
    void deleteMemberByUserName(@PathVariable String userName){

    }
}
