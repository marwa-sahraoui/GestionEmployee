package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Mission;
import com.example.gestionemployee.service.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping
    public List<Mission> findAll() {
        return missionService.findAll();
    }

    @GetMapping("/{id}")
    public Mission findById(@PathVariable Long id) {
        return missionService.findById(id);
    }

    @PostMapping(path = "/add")
    public Mission save(@RequestBody Mission mission) {
        return missionService.save(mission);
    }

    @PutMapping("/{id}")
    public void updateMission(@PathVariable Long id, @RequestBody Mission mission) {
        missionService.update(mission, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        missionService.deleteById(id);
    }
}
