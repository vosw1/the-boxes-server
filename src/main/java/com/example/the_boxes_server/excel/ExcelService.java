package com.example.the_boxes_server.excel;

import com.example.the_boxes_server.core.util.ExcelUtil;
import com.example.the_boxes_server.history.HistoryResponse;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public byte[] exportDataToExcel(List<HistoryResponse.ListDTO> historyList) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ExcelUtil.exportToExcel(historyList, outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            // 예외 발생 시 로그 출력
            throw new IOException("Failed to create Excel file: " + e.getMessage(), e);
        }
    }
}