package com.expenseai.tracker.controller;

import com.expenseai.tracker.dto.InvestmentDTO;
import com.expenseai.tracker.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<InvestmentDTO> createInvestment(@RequestBody InvestmentDTO investmentDTO) {
        return ResponseEntity.ok(investmentService.createInvestment(investmentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestmentDTO> getInvestmentById(@PathVariable Long id) {
        return ResponseEntity.ok(investmentService.getInvestmentById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<InvestmentDTO>> getInvestmentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(investmentService.getInvestmentsByUser(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvestmentDTO> updateInvestment(@PathVariable Long id, @RequestBody InvestmentDTO investmentDTO) {
        return ResponseEntity.ok(investmentService.updateInvestment(id, investmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }

    // 🧠 Placeholder for AI-based Investment Recommendation
    @GetMapping("/ai-recommend/{userId}")
    public ResponseEntity<String> getAIInvestmentRecommendation(@PathVariable Long userId) {
        // TODO: Integrate AI logic later
        return ResponseEntity.ok("AI Investment Recommendation will be available soon!");
    }
}
