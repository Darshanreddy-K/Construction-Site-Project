DROP TABLE IF EXISTS procurement_requests CASCADE;

CREATE TABLE procurement_requests (
                                      id BIGSERIAL PRIMARY KEY,
                                      item_id BIGINT NOT NULL,
                                      quantity INT NOT NULL,
                                      estimated_cost DOUBLE PRECISION NOT NULL,
                                      status VARCHAR(50) NOT NULL DEFAULT 'DRAFT',
                                      requested_by VARCHAR(100) NOT NULL,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);