package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Payslip;
import com.example.gestionemployee.repository.PayslipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayslipService {
    final PayslipRepository payslipRepository;

    public PayslipService(PayslipRepository payslipRepository) {
        this.payslipRepository = payslipRepository;
    }


    public List<Payslip> findAll() {
        return payslipRepository.findAll();
    }

    public Payslip findById(Long id) {
        return payslipRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid payslip Id: " + id));
    }

    public Payslip save(Payslip payslip) {
        return payslipRepository.save(payslip);
    }

    public void deleteById(Long id) {
        payslipRepository.deleteById(id);
    }

    public void update(Payslip payslip, Long id) {

        Optional<Payslip> payslipOptional = payslipRepository.findById(id);

        if (payslipOptional.isPresent()) {
            Payslip oldPayslip = payslipOptional.get();

            oldPayslip.setDate(payslip.getDate());
            oldPayslip.setSalary(payslip.getSalary());
            payslipRepository.save(payslip);
        } else {
            throw new IllegalStateException("payslip not found");
        }
    }

    public void deleteAll() {
        payslipRepository.deleteAll();
    }
}
