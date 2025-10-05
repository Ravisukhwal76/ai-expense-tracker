package com.expenseai.tracker.service;

import com.expenseai.tracker.dto.BudgetDTO;
import java.util.List;

public interface BudgetService {

    BudgetDTO createBudget(BudgetDTO budgetDTO);

    BudgetDTO getBudgetById(Long id);

    List<BudgetDTO> getBudgetsByUser(Long userId);

    BudgetDTO updateBudget(Long id, BudgetDTO budgetDTO);

    void deleteBudget(Long id);
}
