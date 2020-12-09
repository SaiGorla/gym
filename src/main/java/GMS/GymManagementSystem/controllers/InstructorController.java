/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.controllers;

import GMS.GymManagementSystem.models.Instructor;
import GMS.GymManagementSystem.repos.InstructorRepository;
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
@RequestMapping(path = "instructor")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/add")
    public String showNewInstructorForm(Instructor instructor) {

        return "newInstructor";
    }

    @PostMapping("/add")
    public String addInstructor(@Valid Instructor instructor, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "newInstructor";
        }

        instructorRepository.save(instructor);
        model.addAttribute("instructors", instructorRepository.findAll());

        return "instructorsList";
    }

    @GetMapping()
    public String allInstructors(Model model) {

        model.addAttribute("instructors", instructorRepository.findAll());
        return "instructorsList";

    }

    @GetMapping(path = "/delete/{id}")
    public String deleteInstructor(@PathVariable Integer id, Model model) {

        Optional<Instructor> byId = instructorRepository.findById(id);
        byId.ifPresent(inst -> instructorRepository.delete(inst));

        model.addAttribute("instructors", instructorRepository.findAll());
        return "instructorsList";
    }

    @PostMapping(path = "/edit/{id}")
    public String editInstructor(@PathVariable Integer id, @Valid Instructor instructor, BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            instructor.setId(id);
            return "editInstructor";
        }

        instructorRepository.save(instructor);
        model.addAttribute("instructors", instructorRepository.findAll());
        return "instructorsList";
    }

    @GetMapping("/edit/{id}")
    public String showEditInstructorForm(@PathVariable("id") Integer id, Model model) {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid instructor Id:" + id));

        model.addAttribute("instructor", instructor);
        return "editInstructor";
    }
}

