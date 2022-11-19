package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Consultant;
import com.example.gestionemployee.service.ConsultantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {
    final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @GetMapping
    public List<Consultant> findAll() {
        return consultantService.findAll();
    }

    @GetMapping("/{id}")
    public Consultant findById(@PathVariable Long id) {
        return consultantService.findById(id);
    }

    @PostMapping(path = "/add")
    public Consultant save(@RequestBody Consultant consultant) {
        return consultantService.save(consultant);
    }

    @PutMapping("/{id}")
    public void updateConsultant(@PathVariable Long id, @RequestBody Consultant consultant) {
        consultantService.update(consultant, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        consultantService.deleteById(id);
    }
}
