package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> findAll(
            @RequestParam Optional<LocalDate> date,
            @RequestParam Optional<LocalDate> startDate,
            @RequestParam Optional<LocalDate> endDate,
            @RequestParam Optional<Item.ItemStatus> status,
            @RequestParam Optional<Integer> userId) {

        if (date.isPresent()) {
            // 날짜만 제공된 경우, 하루의 시작과 끝을 설정
            LocalDateTime startOfDay = date.get().atStartOfDay();
            LocalDateTime endOfDay = date.get().atTime(23, 59, 59);
            return inventoryRepository.findByDateRange(startOfDay, endOfDay);
        } else if (startDate.isPresent() && endDate.isPresent()) {
            // 날짜 범위 제공된 경우
            return inventoryRepository.findByDateRange(startDate.get().atStartOfDay(), endDate.get().atTime(23, 59, 59));
        } else if (status.isPresent()) {
            return inventoryRepository.findByStatus(status.get());
        } else if (userId.isPresent()) {
            return inventoryRepository.findByUserId(userId.get());
        } else {
            return inventoryRepository.findAll();
        }
    }
}