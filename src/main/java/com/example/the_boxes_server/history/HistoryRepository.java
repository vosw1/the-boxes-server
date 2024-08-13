package com.example.the_boxes_server.history;

import com.example.the_boxes_server.inout.InOut;
import com.example.the_boxes_server.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    /**
     * @param date 조회할 날짜
     * @return 해당 날짜의 변동 내역 리스트
     */
    @Query("SELECT h FROM History h WHERE h.createdAt = :date")
    List<History> findByDate(@Param("date") LocalDateTime date);

    /**
     * @param startDate 시작 날짜
     * @param endDate   종료 날짜
     * @return 해당 날짜 범위의 변동 내역 리스트
     */
    @Query("SELECT h FROM History h WHERE h.createdAt BETWEEN :startDate AND :endDate")
    List<History> findByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    /**
     * @param status 품목 상태
     * @return 해당 품목 상태의 변동 내역 리스트
     */
    @Query("SELECT h FROM History h JOIN h.item it WHERE it.status = :status")
    List<History> findByStatus(@Param("status") Item.ItemStatus status);
}