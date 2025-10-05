package com.expenseai.tracker.service;

import com.expenseai.tracker.dto.ExpenseDTO;
import java.util.List;

public interface ExpenseService {

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO getExpenseById(Long id);

    List<ExpenseDTO> getExpensesByUser(Long userId);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
