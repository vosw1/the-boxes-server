package com.example.the_boxes_server.core.util;

import com.example.the_boxes_server.history.HistoryResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class ExcelUtil {

    public static void exportToExcel(List<HistoryResponse.ListDTO> dataList, String filePath) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("History");

            CellStyle dateCellStyle = workbook.createCellStyle();
            CellStyle dateTimeCellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
            dateTimeCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));

            int rowIndex = 0;
            for (HistoryResponse.ListDTO data : dataList) {
                Row row = sheet.createRow(rowIndex++);

                Cell dateCell = row.createCell(0);
                LocalDateTime localDate = data.getCreatedAt();
                dateCell.setCellValue(localDate.toString());
                dateCell.setCellStyle(dateCellStyle);


                Cell dateTimeCell = row.createCell(1);
                LocalDateTime localDateTime = data.getCreatedAt();
                dateTimeCell.setCellValue(localDateTime);
                dateTimeCell.setCellStyle(dateTimeCellStyle);
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }
}
