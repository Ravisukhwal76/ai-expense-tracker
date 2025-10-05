package com.expenseai.tracker.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentDTO {
    private Long id;
    private Long userId;
    private String type;
    private Double amount;
    private LocalDate date;
}
