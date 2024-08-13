package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.core.exceotions.Exception404;
import com.example.the_boxes_server.inventory.Inventory;
import com.example.the_boxes_server.inventory.InventoryRepository;
import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.item.ItemRepository;
import com.example.the_boxes_server.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.the_boxes_server.history.History;
import com.example.the_boxes_server.history.HistoryRepository;


@RequiredArgsConstructor
@Service
public class InOutService {

    private final InventoryRepository inventoryRepository;
    private final InOutRepository inOutRepository;
    private final ItemRepository itemRepository;
    private final HistoryRepository historyRepository;

    @Transactional
    public InOutResponse.SaveDTO save(int itemId, InOutRequest.SaveDTO reqDTO, User sessionUser) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));

        Inventory inventory = inventoryRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("재고 기록을 찾을 수 없습니다"));

        InOut inOut = reqDTO.toEntity(sessionUser, item);
        inOut.setItem(item);

        Integer inComing = reqDTO.getInComing();
        Integer outGoing = reqDTO.getOutComing();

        // 현재 재고 수량 저장
        Integer previousQuantity = inventory.getCurrentQuantity();

        // Inventory 업데이트
        inventory.update(inComing, outGoing);
        inventoryRepository.save(inventory);

        // InOut 저장
        InOut savedInOut = inOutRepository.save(inOut);

        // History 저장
        History history = History.builder()
                .item(item)
                .inOut(savedInOut)
                .inventory(inventory)
                .previousQuantity(previousQuantity) // 업데이트 전에 저장한 이전 수량
                .currentQuantity(inventory.getCurrentQuantity()) // 업데이트 후 현재 수량
                .build();

        // 로그 추가
        System.out.println("Saving history: " + history);

        // History 저장
        historyRepository.save(history);

        return new InOutResponse.SaveDTO(savedInOut);
    }
}