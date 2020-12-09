/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.controllers;

import GMS.GymManagementSystem.models.Schedule;
import GMS.GymManagementSystem.repos.InstructorRepository;
import GMS.GymManagementSystem.repos.MemberRepository;
import GMS.GymManagementSystem.repos.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 *
 * @author Sai Rohith Gorla
 */
@Controller
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/add")
    public String showNewScheduleCreationForm(Schedule schedule, Model model) {
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("instructors", instructorRepository.findAll());
        return "newSchedule";
    }

    @PostMapping("/add")
    public String addSchedule(@Valid Schedule schedule, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("members", memberRepository.findAll());
            model.addAttribute("instructors", instructorRepository.findAll());
            return "newSchedule";
        }

        scheduleRepository.save(schedule);
        model.addAttribute("schedules", scheduleRepository.findAll());
        return "scheduleList";
    }

    @GetMapping()
    public String allSchedules(Model model) {

        model.addAttribute("schedules", scheduleRepository.findAll());
        return "scheduleList";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteSchedule(@PathVariable Integer id, Model model) {

        Optional<Schedule> byId = scheduleRepository.findById(id);
        byId.ifPresent(sch -> scheduleRepository.delete(sch));
        model.addAttribute("schedules", scheduleRepository.findAll());
        return "scheduleList";
    }

    @PostMapping(path = "/edit/{id}")
    public String editScheduler(@PathVariable Integer id, @Valid Schedule schedule, BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            schedule.setId(id);
            model.addAttribute("members", memberRepository.findAll());
            model.addAttribute("instructors", instructorRepository.findAll());
            return "editSchedule";
        }

        scheduleRepository.save(schedule);
        model.addAttribute("schedules", scheduleRepository.findAll());
        return "scheduleList";
    }

    @GetMapping("/edit/{id}")
    public String showEditScheduleForm(@PathVariable("id") Integer id, Model model) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule Id:" + id));

        model.addAttribute("schedule", schedule);
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("instructors", instructorRepository.findAll());
        return "editSchedule";
    }

    @GetMapping(path = "/search")
    public String searchSchedulesByMemberName(@RequestParam String query, Model model) {

        List<Schedule> schedulesFound = scheduleRepository.findByMemberNameContaining(query);
        model.addAttribute("schedules", schedulesFound);
        return "scheduleList";
    }
}

