-- CUSTOMER DB
CREATE DATABASE customer_db;

CREATE SCHEMA public;

CREATE TABLE customer_data(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    phone   VARCHAR(15),
    email   VARCHAR(150),
    address VARCHAR(200),
    age     INTEGER
);

-- PRODUCT DB
CREATE DATABASE product_db;

CREATE SCHEMA public;

CREATE TABLE product_data(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    category    VARCHAR(255),
    model       VARCHAR(255),
    price       BIGINT
);

-- ORDER DB
CREATE DATABASE order_db;

CREATE SCHEMA public;

CREATE TABLE order_data(
    order_id      SERIAL PRIMARY KEY,
    customer_id   VARCHAR(255),
    product_id    VARCHAR(255),
    customer_name VARCHAR(255),
    order_value   BIGINT
);