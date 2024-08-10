package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.history.HistoryRepository;
import com.example.the_boxes_server.inventory.InventoryRepository;
import com.example.the_boxes_server.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InOutService {

    private final InventoryService inventoryService;
    private final InventoryRepository inventoryRepository;
    private final HistoryRepository historyRepository;

    @Transactional
    public void processInOutOrder(InOut inOutOrder) throws Exception {
    }
}
