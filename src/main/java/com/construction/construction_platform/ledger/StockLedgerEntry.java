package com.construction.construction_platform.ledger;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_ledger_entries")
public class StockLedgerEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "quantity_change", nullable = false)
    private Integer quantityChange;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private StockTransactionType transactionType;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Default constructor required by JPA
    public StockLedgerEntry() {}

    public StockLedgerEntry(Long itemId, Integer quantityChange, StockTransactionType transactionType, String referenceId) {
        this.itemId = itemId;
        this.quantityChange = quantityChange;
        this.transactionType = transactionType;
        this.createdAt = LocalDateTime.now();
        this.referenceId = referenceId;
    }

    // Getters
    public Long getId() { return id; }
    public Long getItemId() { return itemId; }
    public Integer getQuantityChange() { return quantityChange; }
    public StockTransactionType getTransactionType() { return transactionType; }
    public String getReferenceId() { return referenceId; }
    public LocalDateTime createdAt() { return createdAt; }
}