package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Mission;
import com.example.gestionemployee.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<Mission> findAll() {
        return missionRepository.findAll();
    }

    public Mission findById(Long id) {
        return missionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid mission Id: " + id));
    }

    public Mission save(Mission mission) {
        return missionRepository.save(mission);
    }

    public void deleteById(Long id) {
        missionRepository.deleteById(id);
    }

    public void update(Mission mission, Long id) {

        Optional<Mission> missionOptional = missionRepository.findById(id);

        if (missionOptional.isPresent()) {
            Mission oldMission = missionOptional.get();

            oldMission.setDate(mission.getDate());
            oldMission.setTgm(mission.getTgm());
            oldMission.setClient(mission.getClient());
            missionRepository.save(mission);
        } else {
            throw new IllegalStateException("payslip not found");
        }
    }

    public void deleteAll() {
        missionRepository.deleteAll();
    }
}
