package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.the_boxes_server.core.util.ApiUtil;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final HttpSession session;
    private final ItemService itemService;

    @GetMapping("/api/item")
    public ResponseEntity<?> list() {
        List<ItemResponse.ListDTO> itemList = itemService.list();
        return ResponseEntity.ok(new ApiUtil<>(itemList));
    }

    @PostMapping("/api/item")
    public ResponseEntity<?> save(@RequestBody ItemRequest.SaveDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ItemResponse.SaveDTO resDTO = itemService.save(reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }

    @PutMapping("/api/item/{itemId}")
    public ResponseEntity<?> update(@PathVariable int itemId, @RequestBody ItemRequest.UpdateDTO reqDTO) {
        ItemResponse.UpdateDTO resDTO = itemService.update(itemId, reqDTO);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }

    @DeleteMapping("/api/item/{itemId}")
    public ResponseEntity<?> delete(@PathVariable Integer itemId) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ItemResponse.RemoveDTO resDTO = itemService.remove(itemId, sessionUser.getUserId());
        return ResponseEntity.ok(new ApiUtil<>(null));
    }
}
