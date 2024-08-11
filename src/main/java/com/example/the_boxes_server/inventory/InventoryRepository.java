package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    /**
     * @param date 조회할 날짜 (시간 부분을 무시하고 날짜만 기준으로 조회)
     * @return 해당 날짜의 재고 리스트
     */
    @Query("SELECT i FROM Inventory i WHERE FUNCTION('DATE', i.createdAt) = FUNCTION('DATE', :date)")
    List<Inventory> findByDate(@Param("date") LocalDateTime date);

    /**
     * @param startDate 시작 날짜
     * @param endDate 종료 날짜
     * @return 해당 날짜 범위의 재고 리스트
     */
    @Query("SELECT i FROM Inventory i WHERE i.createdAt BETWEEN :startDate AND :endDate")
    List<Inventory> findByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    /**
     * @param status 품목 상태
     * @return 해당 품목 상태의 재고 리스트
     */
    @Query("SELECT i FROM Inventory i JOIN i.item it WHERE it.status = :status")
    List<Inventory> findByStatus(@Param("status") Item.ItemStatus status);
}
