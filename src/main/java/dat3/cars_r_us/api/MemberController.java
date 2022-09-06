package dat3.cars_r_us.api;

import dat3.cars_r_us.dto.MemberRequest;
import dat3.cars_r_us.dto.MemberResponse;
import dat3.cars_r_us.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    //Security USER
    //----------------------------------------------------

    // kommer ind som JSON
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }



    //Security ADMIN
    //----------------------------------------------------

    @GetMapping("/admin/all")
    public List<MemberResponse> getMembers(){
        return memberService.findMembers();
    }

    @GetMapping(path = "/admin/{username}")
    public MemberResponse getMemberById(@PathVariable String username) throws Exception{
        return memberService.findMemberByUsername(username);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        memberService.editMember(body,username);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @PatchMapping("/admin/ranking/{username}/{ranking}")
    public void setRanking(@PathVariable String username, @PathVariable int ranking){
        memberService.setRankingForUser(username, ranking);
    }

    @DeleteMapping("/{username}")
    void deleteMemberByUserName(@PathVariable String username){
        memberService.deleteByUsername(username);
    }
}
