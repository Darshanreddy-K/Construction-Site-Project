package com.construction.construction_platform.ledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockLedgerRepository extends JpaRepository<StockLedgerEntry, Long> {

    // Native PostgreSQL Window Function query to calculate real-time running balance
    @Query(value = """
        SELECT 
            id,
            item_id,
            quantity_change,
            transaction_type,
            reference_id,
            created_at,
            SUM(quantity_change) OVER (
                PARTITION BY item_id 
                ORDER BY created_at ASC, id ASC
                ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
            ) AS running_balance
        FROM stock_ledger_entries
        WHERE item_id = :itemId
        """, nativeQuery = true)
    List<Object[]> getStockLedgerWithRunningBalance(@Param("itemId") Long itemId);
}