INSERT INTO USERS (id, name, email, password, created, modified, last_login, is_active)
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

INSERT INTO PHONES (id, number, city_code, country_code, user_id)
VALUES (
    X'3fa85f6457174562b3fc2c963f66afa7',
    '123456789',
    '123',
    '1',
    X'3fa85f6457174562b3fc2c963f66afa6'
);

