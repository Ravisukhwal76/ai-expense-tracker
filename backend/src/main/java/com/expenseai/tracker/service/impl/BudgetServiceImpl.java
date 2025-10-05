package com.expenseai.tracker.service.impl;

import com.expenseai.tracker.dto.BudgetDTO;
import com.expenseai.tracker.entity.Budget;
import com.expenseai.tracker.exception.ResourceNotFoundException;
import com.expenseai.tracker.repository.BudgetRepository;
import com.expenseai.tracker.service.BudgetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;

    public BudgetServiceImpl(BudgetRepository budgetRepository, ModelMapper modelMapper) {
        this.budgetRepository = budgetRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BudgetDTO createBudget(BudgetDTO budgetDTO) {
        Budget budget = modelMapper.map(budgetDTO, Budget.class);
        return modelMapper.map(budgetRepository.save(budget), BudgetDTO.class);
    }

    @Override
    public BudgetDTO getBudgetById(Long id) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Budget not found with ID: " + id));
        return modelMapper.map(budget, BudgetDTO.class);
    }

    @Override
    public List<BudgetDTO> getBudgetsByUser(Long userId) {
        return budgetRepository.findByUserId(userId)
                .stream()
                .map(budget -> modelMapper.map(budget, BudgetDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BudgetDTO updateBudget(Long id, BudgetDTO budgetDTO) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Budget not found with ID: " + id));

        modelMapper.map(budgetDTO, existingBudget);
        return modelMapper.map(budgetRepository.save(existingBudget), BudgetDTO.class);
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
