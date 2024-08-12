package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.core.util.ApiUtil;
import com.example.the_boxes_server.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inout")
public class InOutController {

    private final InOutService inOutService;
    private final HttpSession session;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestParam int itemId,
            @RequestBody InOutRequest.SaveDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
        InOutResponse.SaveDTO resDTO = inOutService.save(itemId, reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil<>(resDTO));
    }
}