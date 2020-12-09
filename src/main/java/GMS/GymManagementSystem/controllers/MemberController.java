/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.controllers;

import GMS.GymManagementSystem.models.Member;
import GMS.GymManagementSystem.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import javax.validation.Valid;

/**
 *
 * @author Sai Rohith Gorla
 */
@Controller
@RequestMapping(path = "member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/add")
    public String showNewMemberForm(Member member) {

        return "newMember";
    }

    @PostMapping("/add")
    public String addMember(@Valid Member member, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "newMember";
        }

        memberRepository.save(member);
        model.addAttribute("members", memberRepository.findAll());

        return "membersList";
    }

    @GetMapping()
    public String allMembers(Model model) {

        model.addAttribute("members", memberRepository.findAll());
        return "membersList";

    }

    @GetMapping(path = "/delete/{id}")
    public String deleteMember(@PathVariable Integer id, Model model) {

        Optional<Member> byId = memberRepository.findById(id);
        byId.ifPresent(memb -> memberRepository.delete(memb));

        model.addAttribute("members", memberRepository.findAll());
        return "membersList";
    }

    @PostMapping(path = "/edit/{id}")
    public String editMember(@PathVariable Integer id, @Valid Member member, BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            member.setId(id);
            return "editMember";
        }

        memberRepository.save(member);
        model.addAttribute("members", memberRepository.findAll());
        return "membersList";
    }

    @GetMapping("/edit/{id}")
    public String showEditMemberForm(@PathVariable("id") Integer id, Model model) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));

        model.addAttribute("member", member);
        return "editMember";
    }
}

