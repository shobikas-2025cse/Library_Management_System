package com.example.demo_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_project.service.MemberService;
import com.model.Member;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/members")
public class MemberWebController {

    private final MemberService memberService;

    public MemberWebController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String showMembers(Model model) {
        model.addAttribute("members", memberService.getMembers());
        return "Member";
    }

    @GetMapping("/new")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "AddMember";
    }

    @PostMapping("/save")
    public String saveMember(@Valid @ModelAttribute("member") Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "AddMember";
        }

        memberService.addMember(member);
        return "redirect:/api/members";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "EditMember";
    }

    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable Long id,
                              @Valid @ModelAttribute("member") Member member,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "EditMember";
        }

        memberService.updateMember(id, member);
        return "redirect:/api/members";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/api/members";
    }
}
