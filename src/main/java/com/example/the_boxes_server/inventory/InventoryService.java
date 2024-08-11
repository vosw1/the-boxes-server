package com.example.the_boxes_server.inventory;

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
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse.ListDTO> list(Optional<LocalDate> date,
                                                      Optional<LocalDate> startDate,
                                                      Optional<LocalDate> endDate,
                                                      Optional<Item.ItemStatus> status,
                                                      Optional<Integer> userId) {
        List<Inventory> inventories;

        if (date.isPresent()) {
            LocalDateTime startOfDay = date.get().atStartOfDay();
            LocalDateTime endOfDay = date.get().atTime(23, 59, 59);
            inventories = inventoryRepository.findByDateRange(startOfDay, endOfDay);
        } else if (startDate.isPresent() && endDate.isPresent()) {
            inventories = inventoryRepository.findByDateRange(startDate.get().atStartOfDay(), endDate.get().atTime(23, 59, 59));
        } else if (status.isPresent()) {
            inventories = inventoryRepository.findByStatus(status.get());
        } else if (userId.isPresent()) {
            inventories = inventoryRepository.findByUserId(userId.get());
        } else {
            inventories = inventoryRepository.findAll();
        }

        return inventories.stream()
                .map(InventoryResponse::createListDTO) // Use the static factory method
                .collect(Collectors.toList());
    }
}