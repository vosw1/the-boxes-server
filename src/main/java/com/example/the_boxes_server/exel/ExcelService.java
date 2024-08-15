package com.example.the_boxes_server.exel;

import com.example.the_boxes_server.core.util.ExcelUtil;
import com.example.the_boxes_server.history.HistoryResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public byte[] exportDataToExcel(List<HistoryResponse.ListDTO> historyList) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Create a temporary file path or use a path from configuration if necessary
            String tempFilePath = "temp.xlsx";

            // Export data to Excel file
            ExcelUtil.exportToExcel(historyList, tempFilePath);

            // Read the file into a byte array
            try (Workbook workbook = new XSSFWorkbook(tempFilePath)) {
                workbook.write(outputStream);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Failed to export data to Excel", e);
        }
    }
}