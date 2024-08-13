package com.example.the_boxes_server.item;

import com.example.the_boxes_server.core.exceotions.Exception404;
import com.example.the_boxes_server.inventory.Inventory;
import com.example.the_boxes_server.inventory.InventoryRepository;
import com.example.the_boxes_server.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;

    // 전체 및 조건별 조회
    @Transactional
    public List<ItemResponse.ListDTO> list(String classification, Item.ItemStatus status) {
        List<Item> items;
        if (classification != null) {
            items = itemRepository.findByClassification(classification);
            System.out.println("Items found by classification '" + classification + "': " + items);
        } else if (status != null) {
            items = itemRepository.findByStatus(status);
            System.out.println("Items found by status '" + status + "': " + items);
        } else {
            Sort sort = Sort.by(Sort.Direction.DESC, "itemId");
            items = itemRepository.findAll(sort);
        }
        return items.stream().map(ItemResponse.ListDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ItemResponse.SaveDTO save(ItemRequest.SaveDTO reqDTO, User sessionUser) {
        // DTO를 엔티티로 변환
        Item item = reqDTO.toEntity(sessionUser);

        // 디버깅 로그 추가
        System.out.println("DTO to Entity conversion: " + item);

        // 새로운 Item 저장
        item = itemRepository.save(item);

        // 저장된 Item과 관련된 Inventory 생성 및 초기화
        Inventory inventory = Inventory.builder()
                .item(item)
                .previousQuantity(0) // 이전 수량을 0으로 설정
                .currentQuantity(0)  // 현재 수량을 0으로 설정
                .build();

        // Inventory 저장
        inventoryRepository.save(inventory);

        // 저장된 엔티티 확인
        System.out.println("Saved item: " + item);
        System.out.println("Initialized inventory: " + inventory);

        return new ItemResponse.SaveDTO(item);
    }

    @Transactional
    public ItemResponse.UpdateDTO update(int itemId, ItemRequest.UpdateDTO reqDTO) {
        // 품목 조회
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));

        // 업데이트 전 로그
        System.out.println("Before update: " + item);

        // DTO의 값을 엔티티에 설정
        if (reqDTO.getItemName() != null) item.setItemName(reqDTO.getItemName());
        if (reqDTO.getClassification() != null) item.setClassification(reqDTO.getClassification());
        if (reqDTO.getItemLocation() != null) item.setItemLocation(reqDTO.getItemLocation());
        if (reqDTO.getStatus() != null) item.setStatus(reqDTO.getStatus());

        item = itemRepository.save(item); // JPA의 변경 감지 기능을 통해 자동으로 저장됨

        // 업데이트 후 로그
        System.out.println("After update: " + item);

        return new ItemResponse.UpdateDTO(item);
    }
}
