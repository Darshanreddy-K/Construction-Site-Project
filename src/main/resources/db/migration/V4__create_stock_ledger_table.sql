CREATE TABLE stock_ledger (
                              id BIGSERIAL PRIMARY KEY,
                              material_name VARCHAR(255) NOT NULL UNIQUE,
                              quantity INT NOT NULL,
                              unit VARCHAR(50) NOT NULL,
                              warehouse_location VARCHAR(255) NOT NULL,
                              last_updated TIMESTAMP WITHOUT TIME ZONE NOT NULL
);