package com.example.f1.controller;

import com.example.f1.entity.F1Entity;
import com.example.f1.repository.F1Repository;
import com.example.f1.request.UserInputRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    F1Repository f1Repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome!");
        return "index";
    }

    @GetMapping("/list")
    public String listRaces(Model model){
        model.addAttribute("races",f1Repository.findAll());
        return "race/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("race", new F1Entity());
        return "race/create";
    }

    @PostMapping("/create")
    public String createRace(@ModelAttribute F1Entity race, RedirectAttributes redirectAttributes) {
        f1Repository.save(race);
        redirectAttributes.addFlashAttribute("successMessage", "Race saved successfully!");
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        F1Entity race = f1Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid race Id:" + id));
        model.addAttribute("race", race);
        return "race/edit";
    }

    @PostMapping("/update/{id}")
    public String updateRace(@PathVariable Long id, @ModelAttribute F1Entity race) {
        race.setId(id);
        f1Repository.save(race);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRace(@PathVariable Long id) {
        f1Repository.deleteById(id);
        return "redirect:/list";
    }
}
