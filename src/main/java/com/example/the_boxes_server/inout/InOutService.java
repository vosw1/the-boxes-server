package com.example.the_boxes_server.inout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InOutService {

    @Transactional
    public void processInOutOrder(InOut inOutOrder) throws Exception {
    }
}
