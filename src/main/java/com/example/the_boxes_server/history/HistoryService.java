package com.example.the_boxes_server.history;

import com.example.the_boxes_server.inout.InOut;
import com.example.the_boxes_server.inventory.Inventory;
import com.example.the_boxes_server.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    @Transactional(readOnly = true)
    public List<HistoryResponse.ListDTO> list(Optional<LocalDate> date,
                                              Optional<LocalDate> startDate,
                                              Optional<LocalDate> endDate,
                                              Optional<Item.ItemStatus> status,
                                              Optional<InOut.ChangeType> changeType) {
        List<History> histories;

        if (date.isPresent()) {
            LocalDateTime startOfDay = date.get().atStartOfDay();
            LocalDateTime endOfDay = date.get().atTime(23, 59, 59);
            histories = historyRepository.findByDateRange(startOfDay, endOfDay);
        } else if (startDate.isPresent() && endDate.isPresent()) {
            histories = historyRepository.findByDateRange(startDate.get().atStartOfDay(), endDate.get().atTime(23, 59, 59));
        } else if (status.isPresent()) {
            histories = historyRepository.findByStatus(status.get());
        } else if (changeType.isPresent()) {
            histories = historyRepository.findByChangeType(changeType.get());
        } else {
            histories = historyRepository.findAll();
        }

        return histories.stream()
                .map(HistoryResponse.ListDTO::new) // Use the constructor
                .collect(Collectors.toList());
    }
}