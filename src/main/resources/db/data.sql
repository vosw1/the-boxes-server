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
    item_id, previous_quantity, current_quantity, created_at
) VALUES
      (1, 90, 100, '2024-08-10 08:00:00'),
      (2, 45, 50, '2024-08-10 09:00:00'),
      (3, 65, 70, '2024-08-10 10:00:00'),
      (4, 25, 30, '2024-08-10 11:00:00'),
      (5, 18, 20, '2024-08-10 12:00:00'),
      (6, 10, 15, '2024-08-10 13:00:00'),
      (7, 7, 8, '2024-08-10 14:00:00'),
      (8, 10, 12, '2024-08-10 15:00:00'),
      (9, 4, 5, '2024-08-10 16:00:00'),
      (10, 6, 7, '2024-08-10 17:00:00');


-- 입출고 테이블에 데이터 삽입
INSERT INTO in_out (
    item_id, in_coming, out_coming, other, user_id, status, created_at
) VALUES
      (1, 10, 0, NULL, 1, 'PENDING', '2024-08-11 09:00:00'),
      (2, 0, 5, NULL, 2, 'APPROVED', '2024-08-11 10:00:00'),
      (3, 0, 5, NULL, 1, 'SHIPPED', '2024-08-11 11:00:00'),
      (4, 0, 5, '제품 교환', 2, 'DELIVERED', '2024-08-11 12:00:00'),
      (5, 10, 0, NULL, 1, 'PENDING', '2024-08-11 13:00:00'),
      (6, 0, 5, NULL, 2, 'APPROVED', '2024-08-11 14:00:00'),
      (7, 0, 1, NULL, 1, 'SHIPPED', '2024-08-11 15:00:00'),
      (8, 2, 0, NULL, 2, 'DELIVERED', '2024-08-11 16:00:00'),
      (9, 0, 1, NULL, 1, 'PENDING', '2024-08-11 17:00:00'),
      (10, 0, 1, '제품 교환', 2, 'APPROVED', '2024-08-11 18:00:00');


-- 히스토리 테이블에 데이터 삽입
INSERT INTO history (
    item_id, in_out_id, inventory_id, created_at
) VALUES
      (1, 1, 1, '2024-08-11 09:00:00'), -- 품목 1의 입고 (in_out_id 1)와 재고 (inventory_id 1) 업데이트
      (2, 2, 2, '2024-08-11 10:00:00'), -- 품목 2의 출고 (in_out_id 2)와 재고 (inventory_id 2) 업데이트
      (3, 3, 3, '2024-08-11 11:00:00'), -- 품목 3의 출고 (in_out_id 3)와 재고 (inventory_id 3) 업데이트
      (4, 4, 4, '2024-08-11 12:00:00'), -- 품목 4의 출고 (in_out_id 4)와 재고 (inventory_id 4) 업데이트
      (5, 5, 5, '2024-08-11 13:00:00'), -- 품목 5의 입고 (in_out_id 5)와 재고 (inventory_id 5) 업데이트
      (6, 6, 6, '2024-08-11 14:00:00'), -- 품목 6의 출고 (in_out_id 6)와 재고 (inventory_id 6) 업데이트
      (7, 7, 7, '2024-08-11 15:00:00'), -- 품목 7의 출고 (in_out_id 7)와 재고 (inventory_id 7) 업데이트
      (8, 8, 8, '2024-08-11 16:00:00'), -- 품목 8의 입고 (in_out_id 8)와 재고 (inventory_id 8) 업데이트
      (9, 9, 9, '2024-08-11 17:00:00'), -- 품목 9의 출고 (in_out_id 9)와 재고 (inventory_id 9) 업데이트
      (10, 10, 10, '2024-08-11 18:00:00'); -- 품목 10의 출고 (in_out_id 10)와 재고 (inventory_id 10) 업데이트


