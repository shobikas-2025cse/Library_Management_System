package com.example.demo_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Member;
import com.repository.MemberRepo;

@Service
public class MemberService {

    private final MemberRepo repository;

    public MemberService(MemberRepo repository) {
        this.repository = repository;
    }

    // Add member
    public Member addMember(Member member) {
        return repository.save(member);
    }

    // Get all members
    public List<Member> getMembers() {
        return repository.findAll();
    }

    // Get member by ID
    public Member getMember(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update member
    public Member updateMember(Long id, Member updateMember) {

        Member existingMember = repository.findById(id).orElse(null);

        if (existingMember == null) {
            return null;
        }

        existingMember.setName(updateMember.getName());
        existingMember.setEmail(updateMember.getEmail());
        existingMember.setPhoneNumber(updateMember.getPhoneNumber());

        return repository.save(existingMember);
    }

    // Delete member
    public void deleteMember(Long id) {
        repository.deleteById(id);
    }
}