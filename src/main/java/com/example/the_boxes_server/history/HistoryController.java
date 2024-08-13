package com.example.the_boxes_server.history;

import com.example.the_boxes_server.core.util.ApiUtil;
import com.example.the_boxes_server.inout.InOut;
import com.example.the_boxes_server.inventory.InventoryResponse;
import com.example.the_boxes_server.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;

    // 전체 및 조건별 조회
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam Optional<LocalDate> date,
            @RequestParam Optional<LocalDate> startDate,
            @RequestParam Optional<LocalDate> endDate,
            @RequestParam Optional<Item.ItemStatus> status) {

        List<HistoryResponse.ListDTO> historyList = historyService.list(date, startDate, endDate, status);

        return ResponseEntity.ok(new ApiUtil<>(historyList));
    }
}