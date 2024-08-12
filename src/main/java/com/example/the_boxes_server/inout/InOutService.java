package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.core.exceotions.Exception404;
import com.example.the_boxes_server.inventory.Inventory;
import com.example.the_boxes_server.inventory.InventoryRepository;
import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.item.ItemRepository;
import com.example.the_boxes_server.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InOutService {

    private final InventoryRepository inventoryRepository;
    private final InOutRepository inOutRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public InOutResponse.SaveDTO save(int itemId, InOutRequest.SaveDTO reqDTO, User sessionUser) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));

        Inventory inventory = inventoryRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("재고 기록을 찾을 수 없습니다"));

        InOut inOut = reqDTO.toEntity(sessionUser, item);

        inOut.setItem(item);

        inventory.update(reqDTO.getOrderType(), reqDTO.getQuantity());
        inventoryRepository.save(inventory);

        InOut savedInOut = inOutRepository.save(inOut);

        return new InOutResponse.SaveDTO(savedInOut);
    }
}
