package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.the_boxes_server.core.util.ApiUtil;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final HttpSession session;
    private final ItemService itemService;

    @PostMapping("/api/item/save")
    public ResponseEntity<?> save(ItemRequest.SaveDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ItemResponse.SaveDTO resDTO = itemService.save(reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }

}
