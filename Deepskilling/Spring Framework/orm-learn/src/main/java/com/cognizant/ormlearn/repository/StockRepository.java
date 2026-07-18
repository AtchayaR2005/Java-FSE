package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByStockCodeAndStockDateBetweenOrderByStockDateAsc(
            String stockCode, LocalDate startDate, LocalDate endDate);

    List<Stock> findByStockCodeAndStockCloseGreaterThan(String stockCode, BigDecimal stockClose);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByStockCodeOrderByStockCloseAsc(String stockCode);
}
