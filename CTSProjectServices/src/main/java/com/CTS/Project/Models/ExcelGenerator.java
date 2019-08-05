package com.CTS.Project.Models;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelGenerator {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "resource" })
	public ByteArrayInputStream attendenceToExcel(String tableName) throws IOException {
		List<String> list = (List<String>) entityManager.createNativeQuery("SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name='"+tableName+"'").getResultList();
		List<String> COLUMNs = new ArrayList<String>();
		for (String obj : list) {
			String words[] = obj.split("_");
			String capitalizeWord = "";
			for (String w : words) {
				String first = w.substring(0, 1);
				String afterfirst = w.substring(1);
				capitalizeWord += first.toUpperCase() + afterfirst + " ";
			}
			COLUMNs.add(capitalizeWord);
		}

		List<Object[]> data = (List<Object[]>) entityManager.createNativeQuery("SELECT * FROM "+tableName).getResultList();

		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet(tableName);

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Row for Header
		Row headerRow = sheet.createRow(0);

		// Header
		for (int col = 0; col < COLUMNs.size(); col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(COLUMNs.get(col));
			cell.setCellStyle(headerCellStyle);
		}

		// CellStyle for Age
		CellStyle ageCellStyle = workbook.createCellStyle();
		ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

		int rowIdx = 1;
		for (Object[] objData : data) {
			Row row = sheet.createRow(rowIdx++);
			for (int i = 0; i < objData.length; i++) {
				row.createCell(i).setCellValue(objData[i].toString());
			}
		}

		workbook.write(out);

		return new ByteArrayInputStream(out.toByteArray());

	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	public ByteArrayInputStream createCustoneExcel(String headerNames,String tableQuery,String excelName) throws IOException {
		
		String [] COLUMNs=headerNames.split(",");

		List<Object[]> data = (List<Object[]>) entityManager.createNativeQuery(tableQuery).getResultList();

		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Sheet sheet = workbook.createSheet(excelName);

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Row for Header
		Row headerRow = sheet.createRow(0);

		// Header
		for (int col = 0; col < COLUMNs.length; col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(COLUMNs[col]);
			cell.setCellStyle(headerCellStyle);
		}

         
		int rowIdx = 1;
		for (Object[] objData : data) {
			Row row = sheet.createRow(rowIdx++);
			for (int i = 0; i < objData.length; i++) {
				row.createCell(i).setCellValue(objData[i].toString());
			}
		}

		workbook.write(out);

		return new ByteArrayInputStream(out.toByteArray());

	}
	
	
}