package com.spendwise;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.spendwise.dto.SpendInputDTO;
import com.spendwise.enums.Type;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private final Workbook workbook;
    private final Sheet sheet;

    private ExcelReader(File excelFile) throws InvalidFormatException, IOException {
        workbook = new XSSFWorkbook(excelFile);
        sheet = workbook.getSheetAt(0);
    }

    public static void main(String[] args) throws InvalidFormatException, IOException {
        File excelFile = Paths.get("").resolve("./planilhas/spendwise-planilha.xlsx").toFile();
        ExcelReader reader = new ExcelReader(excelFile);
        reader.readFromExcelFile();
    }

    private List<SpendInputDTO> readFromExcelFile() throws IOException {
        List<SpendInputDTO> spends = new ArrayList<>();

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            Cell dateCell = row.getCell(0);
            Cell descCell = row.getCell(1);
            Cell categoryCell = row.getCell(2);
            Cell valueCell = row.getCell(3);
            Cell typeCell = row.getCell(4);

            LocalDate date = null;
            String description = "";
            String category = "";
            BigDecimal value = BigDecimal.ZERO;
            Type type = Type.INPUT;

            if (dateCell != null && DateUtil.isCellDateFormatted(dateCell)) {
                date = dateCell.getLocalDateTimeCellValue().toLocalDate();
            }

            if (descCell != null) {
                description = descCell.getStringCellValue().trim();
            }

            if (categoryCell != null) {
                category = categoryCell.getStringCellValue().trim();
            }

            if (valueCell != null) {
                value = BigDecimal.valueOf(valueCell.getNumericCellValue());
            }

            if (typeCell != null) {
                type = Type.valueOf(typeCell.getStringCellValue().toUpperCase());
            }

            spends.add(new SpendInputDTO(date, description, category, value, type));
        }

        workbook.close();

        return spends;
    }
}