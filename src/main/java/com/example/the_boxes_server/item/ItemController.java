package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final HttpSession session;
    private final ItemService itemService;

    @PostMapping("/api/item/save")
    public String save(ItemRequest.SaveDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        itemService.save(reqDTO, sessionUser);
        return "ok";
    }
}
