package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {


    @Test
    public void writeExcel() throws IOException {
        String path=".\\src\\test\\resources\\ULKELER.xlsx";
        //file acalim
        FileInputStream file=new FileInputStream(path);
       //workbooku acalim
        Workbook workbook= WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheetAt(0); //1.sheete git
        Row row=sheet.getRow(0);   //1,rowa git basliklar
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        Cell cell=row.createCell(3);//cell creat
        cell.setCellValue("NUFUS"); //cell e yazdir

Cell cell5 =row.createCell(4);
cell5.setCellValue("YUZOLCUMU");
row.removeCell(cell5);//silmek icin remove() methodunu kullaniyoruz.

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("12345667");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("32323332");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("23242343");


        workbook.write((fileOutputStream));

        fileOutputStream.close();
        file.close();
        workbook.close();


    }
}
