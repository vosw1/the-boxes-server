package com.example.the_boxes_server.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    // JpaRepository에서 기본 CRUD 메서드가 제공, 필요에 따라 추가적인 쿼리 메서드를 정의 가능
}
