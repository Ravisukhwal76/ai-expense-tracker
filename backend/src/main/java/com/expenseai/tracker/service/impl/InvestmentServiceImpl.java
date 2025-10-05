package com.expenseai.tracker.service.impl;

import com.expenseai.tracker.dto.InvestmentDTO;
import com.expenseai.tracker.entity.Investment;
import com.expenseai.tracker.exception.ResourceNotFoundException;
import com.expenseai.tracker.repository.InvestmentRepository;
import com.expenseai.tracker.service.InvestmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ModelMapper modelMapper;

    public InvestmentServiceImpl(InvestmentRepository investmentRepository, ModelMapper modelMapper) {
        this.investmentRepository = investmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InvestmentDTO createInvestment(InvestmentDTO investmentDTO) {
        Investment investment = modelMapper.map(investmentDTO, Investment.class);
        return modelMapper.map(investmentRepository.save(investment), InvestmentDTO.class);
    }

    @Override
    public InvestmentDTO getInvestmentById(Long id) {
        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investment not found with ID: " + id));
        return modelMapper.map(investment, InvestmentDTO.class);
    }

    @Override
    public List<InvestmentDTO> getInvestmentsByUser(Long userId) {
        return investmentRepository.findByUserId(userId)
                .stream()
                .map(investment -> modelMapper.map(investment, InvestmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public InvestmentDTO updateInvestment(Long id, InvestmentDTO investmentDTO) {
        Investment existingInvestment = investmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investment not found with ID: " + id));

        modelMapper.map(investmentDTO, existingInvestment);
        return modelMapper.map(investmentRepository.save(existingInvestment), InvestmentDTO.class);
    }

    @Override
    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}
