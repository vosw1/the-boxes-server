package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inout")
public class InOutController {

    private final InventoryService inventoryService;

}
