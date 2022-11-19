package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Activity;
import com.example.gestionemployee.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public List<Activity> findAll() {
        return activityService.findAll();
    }

    @GetMapping("/{id}")
    public Activity findById(@PathVariable Long id) {
        return activityService.findById(id);
    }

    @PostMapping(path = "/add")
    public Activity save(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @PutMapping("/{id}")
    public void updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        activityService.update(activity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        activityService.deleteById(id);
    }
}
