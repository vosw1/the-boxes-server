package com.example.the_boxes_server.item;

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
        item = itemRepository.save(item);
        return new ItemResponse.SaveDTO(item);
    }

    @Transactional
    public ItemResponse.UpdateDTO update(int itemId, ItemRequest.UpdateDTO reqDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception404("해당 품목을 찾을 수 없습니다"));
        item.setItemName(reqDTO.getItemName());
        item.setAmount(reqDTO.getAmount());
        item.setIsActive(reqDTO.getIsActive());

        itemRepository.save(item);

        return new ItemResponse.UpdateDTO(item);
    }
}
