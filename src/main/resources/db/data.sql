INSERT INTO users (username, password, name, address, email, birthdate, phone, position, created_at)
VALUES (
        'asdf',
        'as1234',
        '홍길동',
        '부산광역시 부산진구 가야동',
        'as1234@nate.com',
        '1990-05-15',
        '010-1234-7890',
        '사원',
        now()
       );


INSERT INTO item (item_name, old_quantity, in_quantity, out_quantity, amount, classification, item_location, is_active, created_at)
VALUES
    ('Sample Item', 60, 10, 60, 10, '과자','A-1', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 0, 40, 20, '과자','A-1', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 40, 30, '과자','A-2', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 30, 40, '과자','A-2', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 0, 50, 10, '과자','A-3', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 50, 20, '과자','A-3', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 40, 30, '과자','A-4', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 20, 40, 40, '과자','A-4', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 20, 30, 50, '과자','A-5', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 0, 50, 10, '과자','B-1', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 50, 20, '음료수','B-2', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 20, 50, 30, '음료수','B-3', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 30, 50, 40, '음료수','B-4', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 30, 40, 50, '음료수','B-5', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 10, 60, '음료수','C-1', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 0, 50, 10, '음료수','C-2', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 50, 20, '음료수','C-3', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 40, 30, '음료수','C-4', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 20, 40, 40, '음료수','C-5', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 20, 30, 50, '음료수','D-1', TRUE, CURRENT_TIMESTAMP),
    ('Sample Item', 60, 10, 10, 60, '음료수','D-2', TRUE, CURRENT_TIMESTAMP);





