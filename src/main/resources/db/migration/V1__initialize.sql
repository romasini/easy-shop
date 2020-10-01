CREATE TABLE products (
    id bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price INT);

CREATE TABLE orders (
    id bigserial PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255) NOT NULL
    customer_address VARCHAR(255) NOT NULL,
     price INT);

CREATE TABLE order_items (
    id bigserial PRIMARY KEY,
    product_id bigint NOT NULL REFERENCES products(id),
    order_id bigint NOT NULL REFERENCES orders(id),
    quantity INT,
    price INT);

INSERT INTO products (title, price)
VALUES
('Prod 1', 100),
('Prod 2', 200),
('Prod 3', 300),
('Prod 4', 400),
('Prod 5', 500),
('Prod 6', 600),
('Prod 7', 700),
('Prod 8', 800),
('Prod 9', 900),
('Prod 10', 1000),
('Prod 11', 1100),
('Prod 12', 1200),
('Prod 13', 1300),
('Prod 14', 1400),
('Prod 15', 1500),
('Prod 16', 1600),
('Prod 17', 1700),
('Prod 18', 1800),
('Prod 19', 1900),
('Prod 20', 2000),
('Prod 21', 2100),
('Prod 22', 2200),
('Prod 23', 2300),
('Prod 24', 2400),
('Prod 25', 2500),
('Prod 26', 2600),
('Prod 27', 2700),
('Prod 28', 2800),
('Prod 29', 2900),
('Prod 30', 3000),
('Prod 31', 3100),
('Prod 32', 3200)
;

