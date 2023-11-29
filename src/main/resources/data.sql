CREATE TABLE IF NOT EXISTS users (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS phones (
    id BINARY(16) PRIMARY KEY,
    number VARCHAR(255),
    city_code VARCHAR(255),
    country_code VARCHAR(255),
    user_id BINARY(16),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users (id, name, email, password, created, modified, last_login, is_active)
VALUES (
    X'3fa85f6457174562b3fc2c963f66afa6',
    'Diego Garcia',
    'digarciaalt@gmail.com',
    'password123',
    '2023-01-01 00:00:00',
    '2023-01-01 00:00:00',
    '2023-01-01 00:00:00',
    true
);

INSERT INTO phones (id, number, city_code, country_code, user_id)
VALUES (
    X'3fa85f6457174562b3fc2c963f66afa7',
    '123456789',
    '123',
    '1',
    X'3fa85f6457174562b3fc2c963f66afa6'
);

