CREATE TABLE procurement_orders (
                                    id BIGSERIAL PRIMARY KEY,
                                    material_name VARCHAR(255) NOT NULL,
                                    quantity INT NOT NULL,
                                    status VARCHAR(50) NOT NULL,
                                    requested_by VARCHAR(255) NOT NULL,
                                    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);