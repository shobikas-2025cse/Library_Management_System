package com.example.demo_project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.service.MemberService;
import com.model.Member;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // Get all members
    @GetMapping
    public List<Member> getMembers() {
        return service.getMembers();
    }

    // Add member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return service.addMember(member);
    }

    // Get member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return service.getMember(id);
    }

    // Update member
    @PutMapping("/{id}")
public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
    return service.updateMember(id, member);
}

    // Delete member
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
    }
}