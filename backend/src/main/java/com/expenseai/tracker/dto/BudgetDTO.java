package com.expenseai.tracker.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetDTO {
    private Long id;
    private Long userId;
    private String category;
    private Double amount;
    private LocalDate startDate;
    private LocalDate endDate;
}
