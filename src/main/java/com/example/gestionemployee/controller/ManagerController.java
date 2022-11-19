package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Manager;
import com.example.gestionemployee.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/managers")
public class ManagerController {
    final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public List<Manager> findAll() {
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public Manager findById(@PathVariable Long id) {
        return managerService.findById(id);
    }

    @PostMapping(path = "/add")
    public Manager save(@RequestBody Manager manager) {
        return managerService.save(manager);
    }

    @PutMapping("/{id}")
    public void updateManager(@PathVariable Long id, @RequestBody Manager manager) {
        managerService.update(manager, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        managerService.deleteById(id);
    }
}

