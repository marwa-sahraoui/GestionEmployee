package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Activity;
import com.example.gestionemployee.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid activity Id: " + id));
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public void deleteById(Long id) {
        activityRepository.deleteById(id);
    }

    public void update(Activity activity, Long id) {

        Optional<Activity> activityOptional = activityRepository.findById(id);

        if (activityOptional.isPresent()) {
            Activity oldActivity = activityOptional.get();

            oldActivity.setDaysOff(activity.getDaysOff());
            oldActivity.setDaysOfWork(activity.getDaysOfWork());
            activityRepository.save(activity);
        } else {
            throw new IllegalStateException("payslip not found");
        }
    }

    public void deleteAll() {
        activityRepository.deleteAll();
    }

}

