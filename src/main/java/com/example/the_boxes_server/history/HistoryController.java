package com.example.the_boxes_server.history;

import com.example.the_boxes_server.exel.ExcelService;
import com.example.the_boxes_server.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;
    private final ExcelService excelService;

    // 전체 및 조건별 조회
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam Optional<LocalDate> date,
            @RequestParam Optional<LocalDate> startDate,
            @RequestParam Optional<LocalDate> endDate,
            @RequestParam Optional<Item.ItemStatus> status) {

        List<HistoryResponse.ListDTO> historyList = historyService.list(date, startDate, endDate, status);
        return ResponseEntity.ok(historyList); // 조회된 데이터를 반환
    }

    // 엑셀로 저장
    @PostMapping("/toExcel")
    public ResponseEntity<byte[]> toExcel(@RequestBody List<HistoryResponse.ListDTO> historyList) {
        try {
            byte[] excelFile = excelService.exportDataToExcel(historyList);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=history.xlsx");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
        } catch (IOException e) {
            // 사용중인 로깅 프레임워크로 오류를 로깅합니다.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}