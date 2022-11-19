package com.example.gestionemployee.repository;

import com.example.gestionemployee.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    List<Consultant> findByManagerId(Long managerId);
}
