package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Consultant;
import com.example.gestionemployee.repository.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantService {
    final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    public Consultant findById(Long id) {
        return consultantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid consultant Id: " + id));
    }

    public Consultant save(Consultant consultant) {
        return consultantRepository.save(consultant);
    }

    public void deleteById(Long id) {
        consultantRepository.deleteById(id);
    }

    public void update(Consultant consultant, Long id) {

        Optional<Consultant> consultantOptional = consultantRepository.findById(id);

        if (consultantOptional.isPresent()) {
            Consultant oldConsultant = consultantOptional.get();

            oldConsultant.setName(consultant.getName());
            oldConsultant.setDateOfBirth(consultant.getDateOfBirth());
            oldConsultant.setHiringDate(consultant.getHiringDate());
            consultantRepository.save(consultant);
        } else {
            throw new IllegalStateException("consultant not found");
        }
    }

    public void deleteAll() {
        consultantRepository.deleteAll();
    }
}
