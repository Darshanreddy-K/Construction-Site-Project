package com.construction.construction_platform.ledger;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockLedgerService {

    private final StockLedgerRepository stockLedgerRepository;

    // Constructor-based dependency injection
    public StockLedgerService(StockLedgerRepository stockLedgerRepository) {
        this.stockLedgerRepository = stockLedgerRepository;
    }

    // 1. Record a new immutable stock transaction
    public StockLedgerEntry recordTransaction(Long itemId, Integer quantityChange, StockTransactionType transactionType, String referenceId) {
        StockLedgerEntry entry = new StockLedgerEntry(itemId, quantityChange, transactionType, referenceId);
        return stockLedgerRepository.save(entry);
    }

    // 2. Fetch running balance ledger for a specific material item
    public List<Object[]> getLedgerWithRunningBalance(Long itemId) {
        return stockLedgerRepository.getStockLedgerWithRunningBalance(itemId);
    }
}