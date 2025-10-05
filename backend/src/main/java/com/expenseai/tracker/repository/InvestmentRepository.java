package com.expenseai.tracker.repository;

import com.expenseai.tracker.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findByUserId(Long userId);

    List<Investment> findByUserIdOrderByDateDesc(Long userId);
}
