package com.example.gestionemployee.repository;

import com.example.gestionemployee.model.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Long> {
}
