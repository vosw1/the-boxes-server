-- 사용자 테이블에 데이터 삽입
INSERT INTO users (
    username, password, name, birthdate, phone, address, email, position, status, created_at
) VALUES
      ('asdf', 'as1234', '김석진', '1980-04-12', '010-1234-5678', '서울특별시 강남구 역삼동 123-45', 'kimseok@example.com', 'MANAGER', 'WORKING', now()),
      ('asdfg', 'asd1234', '박지원', '1990-08-22', '010-2345-6789', '부산광역시 해운대구 우동 678-90', 'parkjiwon@example.com', 'EMPLOYEE', 'WORKING', now()),
      ('asqw', 'asdf1234', '이정호', '1985-11-30', '010-3456-7890', '대구광역시 중구 동성로 100', 'leejeong@example.com', 'INTERN', 'RETIRED', now());

-- 품목 테이블에 데이터 삽입
INSERT INTO item (
    classification, item_name, manufacturer, item_location, status, user_id, created_at
) VALUES
      ('전자제품', '노트북', '컴퓨터회사', '선반 A-1', 'IN_USE', 1, now()),
      ('전자제품', '스마트폰', '스마트컴', '선반 A-2', 'IN_USE', 2, now()),
      ('전자제품', '모니터', '화면제작소', '선반 B-1', 'IN_USE', 1, now()),
      ('전자제품', '프린터', '프린트존', '선반 B-2', 'IN_USE', 2, now()),
      ('가구', '의자', '의자회사', '선반 C-1', 'IN_USE', 1, now()),
      ('가구', '책상', '가구제작소', '선반 C-2', 'IN_USE', 2, now()),
      ('가전', '커피머신', '커피프레스', '선반 D-1', 'IN_USE', 1, now()),
      ('가전', '전자레인지', '마이크로웨이브', '선반 D-2', 'IN_USE', 2, now()),
      ('가전', '에어컨', '쿨링시스템', '선반 E-1', 'IN_USE', 1, now()),
      ('가전', '냉장고', '프리저', '선반 E-2', 'IN_USE', 2, now());


-- 인벤토리 테이블에 데이터 삽입
INSERT INTO inventory (
    item_id, current_quantity, created_at
) VALUES
      (1, 90, '2024-08-10 08:00:00'),
      (2, 45, '2024-08-10 09:00:00'),
      (3, 65, '2024-08-10 10:00:00'),
      (4, 25, '2024-08-10 11:00:00'),
      (5, 18, '2024-08-10 12:00:00'),
      (6, 10, '2024-08-10 13:00:00'),
      (7, 7, '2024-08-10 14:00:00'),
      (8, 10, '2024-08-10 15:00:00'),
      (9, 4, '2024-08-10 16:00:00'),
      (10, 6, '2024-08-10 17:00:00');

-- 입출고 테이블에 데이터 삽입
INSERT INTO in_out (
    item_id, order_type, quantity, change_type, reason, user_id, status, created_at
) VALUES
      (1, 'INCOMING', 10, 'STOCK_ADDITION', NULL, 1, 'PENDING', '2024-08-11 09:00:00'),
      (2, 'OUTGOING', 5, 'DAMAGE', NULL, 2, 'APPROVED', '2024-08-11 10:00:00'),
      (3, 'OUTGOING', 5, 'STOCK_REMOVAL', NULL, 1, 'SHIPPED', '2024-08-11 11:00:00'),
      (4, 'OUTGOING', 5, 'OTHER', '제품 교환', 2, 'DELIVERED', '2024-08-11 12:00:00'),
      (5, 'INCOMING', 10, 'STOCK_ADDITION', NULL, 1, 'PENDING', '2024-08-11 13:00:00'),
      (6, 'OUTGOING', 5, 'STOCK_REMOVAL', NULL, 2, 'APPROVED', '2024-08-11 14:00:00'),
      (7, 'OUTGOING', 1, 'DAMAGE', NULL, 1, 'SHIPPED', '2024-08-11 15:00:00'),
      (8, 'INCOMING', 2, 'STOCK_ADDITION', NULL, 2, 'DELIVERED', '2024-08-11 16:00:00'),
      (9, 'OUTGOING', 1, 'STOCK_REMOVAL', NULL, 1, 'PENDING', '2024-08-11 17:00:00'),
      (10, 'OUTGOING', 1, 'OTHER', '제품 교환', 2, 'APPROVED', '2024-08-11 18:00:00');

-- 히스토리 테이블에 데이터 삽입
INSERT INTO history (
    item_id, in_out_id, inventory_id, created_at
) VALUES
      (1, 1, 1, '2024-08-10 08:30:00'),
      (2, 2, 2, '2024-08-10 09:30:00'),
      (3, 3, 3, '2024-08-10 10:30:00'),
      (4, 4, 4, '2024-08-10 11:30:00'),
      (5, 5, 5, '2024-08-10 12:30:00'),
      (6, 6, 6, '2024-08-10 13:30:00'),
      (7, 7, 7, '2024-08-10 14:30:00'),
      (8, 8, 8, '2024-08-10 15:30:00'),
      (9, 9, 9, '2024-08-10 16:30:00'),
      (10, 10, 10, '2024-08-10 17:30:00');

