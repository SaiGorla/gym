/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.controllers;

import GMS.GymManagementSystem.models.BMI;
import GMS.GymManagementSystem.models.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
/**
 *
 * @author Sai Rohith Gorla
 */
@Controller
@RequestMapping(path = "bmi")
public class BMICalculatorController {

    @GetMapping()
    public String showBMIPage(BMI bmi, Model model) {

        model.addAttribute("bmi", bmi);
        return "bmi";
    }

    @PostMapping("/calc")
    public String addSchedule(@Valid BMI bmi, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("bmi", bmi);
            return "bmi";
        }
        double bmiValue = bmi.getWeight() / (bmi.getHeight() * bmi.getHeight());
        model.addAttribute("result", String.format("%.2f",bmiValue));
        return "bmiResults";
    }
}
