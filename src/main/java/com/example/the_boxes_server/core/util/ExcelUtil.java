package com.example.the_boxes_server.core.util;

import com.example.the_boxes_server.history.HistoryResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelUtil {

    public static void exportToExcel(List<HistoryResponse.ListDTO> dataList, OutputStream outputStream) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("History");

            // Define date format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "History ID", "Item ID", "Item Name", "Manufacturer", "Item Location",
                    "Classification", "Item Status", "In/Out ID", "In/Out Status", "In Coming",
                    "Price", "Amount", "Out Coming", "User ID", "User Name", "User Position",
                    "User Status", "User Phone", "In/Out Created At", "Inventory ID", "Current Quantity",
                    "Previous Quantity", "Inventory Created At", "Created At"
            };
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Write data rows
            int rowIndex = 1;
            for (HistoryResponse.ListDTO data : dataList) {
                Row row = sheet.createRow(rowIndex++);

                // Item details
                row.createCell(0).setCellValue(data.getHistoryId());
                row.createCell(1).setCellValue(data.getItem().getItemId());
                row.createCell(2).setCellValue(data.getItem().getItemName());
                row.createCell(3).setCellValue(data.getItem().getManufacturer());
                row.createCell(4).setCellValue(data.getItem().getItemLocation());
                row.createCell(5).setCellValue(data.getItem().getClassification());
                row.createCell(6).setCellValue(data.getItem().getStatus().toString());

                // In/Out details
                row.createCell(7).setCellValue(data.getInOut().getInOutId());
                row.createCell(8).setCellValue(data.getInOut().getStatus().name());
                row.createCell(9).setCellValue(data.getInOut().getInComing());
                row.createCell(10).setCellValue(data.getInOut().getPrice());
                row.createCell(11).setCellValue(data.getInOut().getAmount());
                row.createCell(12).setCellValue(data.getInOut().getOutComing());
                row.createCell(13).setCellValue(data.getInOut().getUser().getUsrId());
                row.createCell(14).setCellValue(data.getInOut().getUser().getName());
                row.createCell(15).setCellValue(data.getInOut().getUser().getPosition().toString());
                row.createCell(16).setCellValue(data.getInOut().getUser().getStatus().name());
                row.createCell(17).setCellValue(data.getInOut().getUser().getPhone());
                row.createCell(18).setCellValue(data.getInOut().getCreatedAt().format(dateTimeFormatter));

                // Inventory details
                row.createCell(19).setCellValue(data.getInventory().getInventoryId());
                row.createCell(20).setCellValue(data.getInventory().getCurrentQuantity());
                row.createCell(21).setCellValue(data.getInventory().getPreviousQuantity());
                row.createCell(22).setCellValue(data.getInventory().getCreatedAt().format(dateTimeFormatter));

                // Created At
                row.createCell(23).setCellValue(data.getCreatedAt().format(dateTimeFormatter));
            }

            // Adjust column widths
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to the provided OutputStream
            workbook.write(outputStream);
        }
    }
}
