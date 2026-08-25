package com.matlab.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.matlab.entity.PersonPrefix;

public class ExcelHelper {
	public static List<PersonPrefix> excelToPrefix(InputStream is) throws IOException{
		Workbook workbook=new XSSFWorkbook(is);
		Sheet sheet=workbook.getSheetAt(0);
		List<PersonPrefix> prefixList=new ArrayList<>();
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row=sheet.getRow(i);
			if(row==null)continue;
			PersonPrefix pref=new PersonPrefix();
			pref.setPrefix(row.getCell(0).getStringCellValue());
			pref.setGender(row.getCell(1).getStringCellValue());
			pref.setPrefixOf(row.getCell(2).getStringCellValue());
			pref.setCreatedDate(LocalDateTime.now());
			prefixList.add(pref);
		}
		workbook.close();
		return prefixList;
	}
}
