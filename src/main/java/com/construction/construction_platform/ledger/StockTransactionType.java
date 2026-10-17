package com.construction.construction_platform.ledger;

public enum StockTransactionType {
    INWARD_PROCUREMENT,   // Stock added (+)
    OUTWARD_DISPATCH,     // Stock issued (-)
    DAMAGED_DISPOSAL,     // Damaged material removal (-)
    RECONCILIATION_ADJUST // Stock audit adjustment (+/-)
}