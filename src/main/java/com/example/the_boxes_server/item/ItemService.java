package com.example.the_boxes_server.item;

import com.example.the_boxes_server.core.exceotions.Exception403;
import com.example.the_boxes_server.core.exceotions.Exception404;
import com.example.the_boxes_server.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public List<ItemResponse.ListDTO> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "itemId"); // 필드 이름 수정
        List<Item> itemList = itemRepository.findAll(sort);
        return itemList.stream().map(ItemResponse.ListDTO::new).toList();
    }

    @Transactional
    public ItemResponse.SaveDTO save(ItemRequest.SaveDTO reqDTO, User sessionUser) {
        Item item = reqDTO.toEntity(sessionUser);

        // 디버깅 로그 추가
        System.out.println("DTO to Entity conversion: " + item);

        item = itemRepository.save(item);

        // 저장된 엔티티 확인
        System.out.println("Saved item: " + item);

        return new ItemResponse.SaveDTO(item);
    }


    @Transactional
    public ItemResponse.UpdateDTO update(int itemId, ItemRequest.UpdateDTO reqDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));

        // 업데이트 전 로그
        System.out.println("Before update: " + item);

        if (reqDTO.getItemName() != null) item.setItemName(reqDTO.getItemName());
        if (reqDTO.getAmount() != null) item.setAmount(reqDTO.getAmount());
        if (reqDTO.getClassification() != null) item.setClassification(reqDTO.getClassification());
        if (reqDTO.getItemLocation() != null) item.setItemLocation(reqDTO.getItemLocation());
        if (reqDTO.getIsActive() != null) item.setIsActive(reqDTO.getIsActive());
        if (reqDTO.getOldQuantity() != null) item.setOldQuantity(reqDTO.getOldQuantity());
        if (reqDTO.getInQuantity() != null) item.setInQuantity(reqDTO.getInQuantity());
        if (reqDTO.getOutQuantity() != null) item.setOutQuantity(reqDTO.getOutQuantity());

        item = itemRepository.save(item);

        // 업데이트 후 로그
        System.out.println("After update: " + item);

        return new ItemResponse.UpdateDTO(item);
    }


    @Transactional
    public ItemResponse.RemoveDTO remove(int itemId, Integer sessionUserId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));
        if (sessionUserId != item.getUser().getUserId()) {
            throw new Exception403("해당 품목을 삭제할 권한이 없습니다");
        }
        itemRepository.deleteById(itemId);
        return new ItemResponse.RemoveDTO(item);
    }
}
