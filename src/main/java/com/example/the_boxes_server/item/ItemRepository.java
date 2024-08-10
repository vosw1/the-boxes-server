package com.example.the_boxes_server.item;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    // 분류별 아이템 조회
    List<Item> findByClassification(String classification);

    // 사용품목(예: ACTIVE 상태인 아이템) 조회
    List<Item> findByStatus(Item.ItemStatus status);
}
