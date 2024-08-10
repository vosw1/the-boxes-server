-- 사용자 테이블에 데이터 삽입
INSERT INTO users (
    username, password, name, address, email, birthdate, phone, position, status, created_at
) VALUES
      ('asdf', 'as1234', '김석진', '서울특별시 강남구 역삼동 123-45', 'kimseok@example.com', '1980-04-12', '010-1234-5678', 'MANAGER', 'WORKING', now()),
      ('asdfg', 'asd1234', '박지원', '부산광역시 해운대구 우동 678-90', 'parkjiwon@example.com', '1990-08-22', '010-2345-6789', 'EMPLOYEE', 'WORKING', now()),
      ('asqw', 'asdf1234', '이정호', '대구광역시 중구 동성로 100', 'leejeong@example.com', '1985-11-30', '010-3456-7890', 'INTERN', 'RETIRED', now());

-- 품목 테이블에 데이터 삽입
INSERT INTO item (
    item_name, manufacturer, item_location, classification, user_id, status, created_at
) VALUES
      ('노트북', '컴퓨터회사', '선반 A-1', '전자제품', 1, 'IN_USE', now()),
      ('스마트폰', '스마트컴', '선반 A-2', '전자제품', 2, 'IN_USE', now()),
      ('모니터', '화면제작소', '선반 B-1', '전자제품', 1, 'IN_USE', now()),
      ('프린터', '프린트존', '선반 B-2', '전자제품', 2, 'IN_USE', now()),
      ('의자', '의자회사', '선반 C-1', '가구', 1, 'IN_USE', now()),
      ('책상', '가구제작소', '선반 C-2', '가구', 2, 'IN_USE', now()),
      ('커피머신', '커피프레스', '선반 D-1', '가전', 1, 'IN_USE', now()),
      ('전자레인지', '마이크로웨이브', '선반 D-2', '가전', 2, 'IN_USE', now()),
      ('에어컨', '쿨링시스템', '선반 E-1', '가전', 1, 'IN_USE', now()),
      ('냉장고', '프리저', '선반 E-2', '가전', 2, 'IN_USE', now());

-- 인벤토리 테이블에 데이터 삽입
INSERT INTO inventory (
    item_id, previous_quantity, current_quantity, user_id, created_at
) VALUES
      (1, 100, 90, 1, '2024-08-10 08:00:00'),
      (2, 50, 45, 2, '2024-08-10 09:00:00'),
      (3, 70, 65, 1, '2024-08-10 10:00:00'),
      (4, 30, 25, 2, '2024-08-10 11:00:00'),
      (5, 20, 18, 1, '2024-08-10 12:00:00'),
      (6, 15, 10, 2, '2024-08-10 13:00:00'),
      (7, 8, 7, 1, '2024-08-10 14:00:00'),
      (8, 12, 10, 2, '2024-08-10 15:00:00'),
      (9, 5, 4, 1, '2024-08-10 16:00:00'),
      (10, 7, 6, 2, '2024-08-10 17:00:00');

-- 입출고 테이블에 데이터 삽입
INSERT INTO in_out (
    item_id, order_type, change_type, reason, quantity, status, user_id, created_at
) VALUES
      (1, 'INCOMING', 'STOCK_ADDITION', NULL, 10, 'PENDING', 1, '2024-08-11 09:00:00'),
      (2, 'OUTGOING', 'DAMAGE', NULL, 5, 'APPROVED', 2, '2024-08-11 10:00:00'),
      (3, 'OUTGOING', 'STOCK_REMOVAL', NULL, 5, 'SHIPPED', 1, '2024-08-11 11:00:00'),
      (4, 'OUTGOING', 'OTHER', '고객 분실', 5, 'DELIVERED', 2, '2024-08-11 12:00:00'),
      (5, 'INCOMING', 'STOCK_ADDITION', NULL, 10, 'PENDING', 1, '2024-08-11 13:00:00'),
      (6, 'OUTGOING', 'STOCK_REMOVAL', NULL, 5, 'APPROVED', 2, '2024-08-11 14:00:00'),
      (7, 'OUTGOING', 'DAMAGE', NULL, 1, 'SHIPPED', 1, '2024-08-11 15:00:00'),
      (8, 'INCOMING', 'STOCK_ADDITION', NULL, 2, 'DELIVERED', 2, '2024-08-11 16:00:00'),
      (9, 'OUTGOING', 'STOCK_REMOVAL', NULL, 1, 'PENDING', 1, '2024-08-11 17:00:00'),
      (10, 'OUTGOING', 'OTHER', '제품 교환', 1, 'APPROVED', 2, '2024-08-11 18:00:00');

-- 히스토리 테이블에 데이터 삽입
INSERT INTO history (
    item_id, user_id, inventory_id, in_out_id, created_at
) VALUES
      (1, 1, 1, 1, '2024-08-10 08:30:00'),
      (2, 2, 2, 2, '2024-08-10 09:30:00'),
      (3, 1, 3, 3, '2024-08-10 10:30:00'),
      (4, 2, 4, 4, '2024-08-10 11:30:00'),
      (5, 1, 5, 5, '2024-08-10 12:30:00'),
      (6, 2, 6, 6, '2024-08-10 13:30:00'),
      (7, 1, 7, 7, '2024-08-10 14:30:00'),
      (8, 2, 8, 8, '2024-08-10 15:30:00'),
      (9, 1, 9, 9, '2024-08-10 16:30:00'),
      (10, 2, 10, 10, '2024-08-10 17:30:00');
