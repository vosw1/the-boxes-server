package com.example.the_boxes_server.core.util;

import com.example.the_boxes_server.history.HistoryResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {
    public static List<HistoryResponse.ListDTO> parseJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<HistoryResponse.ListDTO>>(){});
    }

    public static class JsonResponse {
        private int status;
        private String msg;

        @Getter
        private List<HistoryResponse.ListDTO> body;
    }
}
