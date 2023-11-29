CREATE TABLE IF NOT EXISTS USERS (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS PHONES (
    id BINARY(16) PRIMARY KEY,
    number VARCHAR(255),
    city_code VARCHAR(255),
    country_code VARCHAR(255),
    user_id BINARY(16),
    FOREIGN KEY (user_id) REFERENCES users (id)
);