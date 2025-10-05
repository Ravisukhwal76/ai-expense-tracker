package com.expenseai.tracker.repository;

import com.expenseai.tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);

    List<Expense> findByUserIdAndCategory(Long userId, String category);

    List<Expense> findByUserIdOrderByDateDesc(Long userId);
}
