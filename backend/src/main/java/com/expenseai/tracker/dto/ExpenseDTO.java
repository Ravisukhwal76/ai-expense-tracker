package com.expenseai.tracker.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
    private Long id;
    private Long userId;
    private Double amount;
    private String description;
    private String merchant;
    private String category;
    private LocalDate date;
    private Boolean isAiSuggested;
}
