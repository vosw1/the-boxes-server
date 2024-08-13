package com.example.the_boxes_server.item;

import com.example.the_boxes_server.core.util.ApiUtil;
import com.example.the_boxes_server.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final HttpSession session;
    private final ItemService itemService;

    // 전체 및 조건 조회
    @GetMapping
    public ResponseEntity<?> list(
            @RequestParam(required = false) String classification,
            @RequestParam(required = false) Item.ItemStatus status) {

        List<ItemResponse.ListDTO> itemList = itemService.list(classification, status);
        return ResponseEntity.ok(new ApiUtil<>(itemList));
    }

    // 품목 추가
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ItemRequest.SaveDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ItemResponse.SaveDTO resDTO = itemService.save(reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }

    // 품목 수정
    @PutMapping("/{itemId}")
    public ResponseEntity<?> update(@PathVariable Integer itemId, @RequestBody ItemRequest.UpdateDTO reqDTO) {
        ItemResponse.UpdateDTO resDTO = itemService.update(itemId, reqDTO);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }
}
