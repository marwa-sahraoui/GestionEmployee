package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Payslip;
import com.example.gestionemployee.service.PayslipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payslips")
public class PayslipController {

    final PayslipService payslipService;

    public PayslipController(PayslipService payslipService) {
        this.payslipService = payslipService;
    }

    @GetMapping()
    public List<Payslip> findAll() {
        return payslipService.findAll();
    }

    @GetMapping("/{id}")
    public Payslip findById(@PathVariable Long id) {
        return payslipService.findById(id);
    }

    @PostMapping(path = "/add")
    public Payslip save(@RequestBody Payslip payslip) {
        return payslipService.save(payslip);
    }

    @PutMapping("/{id}")
    public void updatePayslip(@PathVariable Long id, @RequestBody Payslip payslip) {
        payslipService.update(payslip, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        payslipService.deleteById(id);
    }
}
