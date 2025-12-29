package com.spendwise;

import com.spendwise.dao.SpendDAO;
import com.spendwise.dto.SpendInputDTO;
import com.spendwise.model.Spend;
import com.spendwise.service.SpendService;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File excelFile = Paths.get("").resolve("./planilhas/spendwise-planilha.xlsx").toFile();
            ExcelReader reader = new ExcelReader(excelFile);

            List<SpendInputDTO> spends = reader.readFromExcelFile();

            SpendService spendService = new SpendService(new Spend(), new SpendDAO());

            for (SpendInputDTO spend : spends) {
                spendService.register(spend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
