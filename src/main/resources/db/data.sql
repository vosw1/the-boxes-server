INSERT INTO users (username, password, name, address, email, birthdate, phone,
                   company_address, industry, logistics_center_location, position, equipment, created_at)
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
        '부산광역시 강서구',
        '사원',
        '바코드',
        '2024-07-01'
       );


INSERT INTO Item (item_id, item_name, amount, is_active, created_at, updated_at)
VALUES (1, 'Sample Item', 100, TRUE, now(), now());



