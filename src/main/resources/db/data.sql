INSERT INTO users (username, password, name, address, email, birthdate, phone,
                   company_address, industry, position, created_at)
VALUES (
        'asdf',
        'as1234',
        '홍길동',
        '부산광역시 부산진구 가야동',
        'as1234@nate.com',
        '1990-05-15',
        '010-1234-7890',
        'Tech Solutions',
        '물류',
        '사원',
        '2024-07-01'
       );


INSERT INTO Item (item_name, amount, classification, item_location, is_active, created_at, updated_at)
VALUES ('Sample Item', 10, '과자','A-1', TRUE, now(), NULL),
       ('Sample Item', 20, '과자','A-1', TRUE, now(), NULL),
       ('Sample Item', 30, '과자','A-2', TRUE, now(), NULL),
       ('Sample Item', 40, '과자','A-2', TRUE, now(), NULL),
       ('Sample Item', 10, '과자','A-3', TRUE, now(), NULL),
       ('Sample Item', 20, '과자','A-3', TRUE, now(), NULL),
       ('Sample Item', 30, '과자','A-4', TRUE, now(), NULL),
       ('Sample Item', 40, '과자','A-4', TRUE, now(), NULL),
       ('Sample Item', 50, '과자','A-5', TRUE, now(), NULL),
       ('Sample Item', 10, '과자','B-1', TRUE, now(), NULL),
       ('Sample Item', 20, '음료수','B-2', TRUE, now(), NULL),
       ('Sample Item', 30, '음료수','B-3', TRUE, now(), NULL),
       ('Sample Item', 40, '음료수','B-4', TRUE, now(), NULL),
       ('Sample Item', 50, '음료수','B-5', TRUE, now(), NULL),
       ('Sample Item', 60, '음료수','C-1', TRUE, now(), NULL),
       ('Sample Item', 10, '음료수','C-2', TRUE, now(), NULL),
       ('Sample Item', 20, '음료수','C-3', TRUE, now(), NULL),
       ('Sample Item', 30, '음료수','C-4', TRUE, now(), NULL),
       ('Sample Item', 40, '음료수','C-5', TRUE, now(), NULL),
       ('Sample Item', 50, '음료수','D-1', TRUE, now(), NULL),
       ('Sample Item', 60, '음료수','D-2', TRUE, now(), NULL);



