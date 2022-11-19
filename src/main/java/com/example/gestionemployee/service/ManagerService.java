package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Manager;
import com.example.gestionemployee.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    public Manager findById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid manager Id: " + id));
    }

    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }

    public void update(Manager manager, Long id) {

        Optional<Manager> managerOptional = managerRepository.findById(id);

        if (managerOptional.isPresent()) {
            Manager oldManager = managerOptional.get();

            oldManager.setName(manager.getName());
            oldManager.setDateOfBirth(manager.getDateOfBirth());
            oldManager.setHiringDate(manager.getHiringDate());
            managerRepository.save(manager);
        } else {
            throw new IllegalStateException("manager not found");
        }
    }

    public void deleteAll() {
        managerRepository.deleteAll();
    }
}
