-- Create Enum Type for Stock Transactions
CREATE TYPE stock_transaction_type AS ENUM (
    'INWARD_PROCUREMENT',
    'OUTWARD_DISPATCH',
    'DAMAGED_DISPOSAL',
    'RECONCILIATION_ADJUST'
);

-- Create Immutable Append-Only Stock Ledger Table
CREATE TABLE stock_ledger_entries (
                                      id BIGSERIAL PRIMARY KEY,
                                      item_id BIGINT NOT NULL,
                                      quantity_change INT NOT NULL,
                                      transaction_type VARCHAR(50) NOT NULL,
                                      reference_id VARCHAR(100),
                                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create Index for Running Balance Window Function Performance
CREATE INDEX idx_stock_ledger_item_date ON stock_ledger_entries(item_id, created_at);