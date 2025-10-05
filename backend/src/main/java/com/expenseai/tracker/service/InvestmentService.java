package com.expenseai.tracker.service;

import com.expenseai.tracker.dto.InvestmentDTO;
import java.util.List;

public interface InvestmentService {

    InvestmentDTO createInvestment(InvestmentDTO investmentDTO);

    InvestmentDTO getInvestmentById(Long id);

    List<InvestmentDTO> getInvestmentsByUser(Long userId);

    InvestmentDTO updateInvestment(Long id, InvestmentDTO investmentDTO);

    void deleteInvestment(Long id);
}
