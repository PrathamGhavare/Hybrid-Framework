package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static XSSFWorkbook workbook;

	public ExcelReader(String excelsheetPath) throws IOException {
		File f = new File(excelsheetPath);
		FileInputStream fis = new FileInputStream(f);

		workbook = new XSSFWorkbook(fis);
	}

	public static int getTotalRowNumber(int SheetIndex) {
		return workbook.getSheetAt(SheetIndex).getLastRowNum();
	}

	public static int getTotalColumnNumber(int SheetIndex) {
		return workbook.getSheetAt(SheetIndex).getRow(0).getLastCellNum();
	}

	public static Object getSheetTestData(int sheetindex, int row, int cell) {
		XSSFCell cells = workbook.getSheetAt(sheetindex).getRow(row).getCell(cell);

		if (cells.getCellType() == CellType.STRING) {
			return cells.getStringCellValue();
		} else if (cells.getCellType() == CellType.BOOLEAN) {
			return cells.getBooleanCellValue();
		} else if (cells.getCellType() == CellType.NUMERIC) {
			return cells.getRowIndex();
		} else if (cells.getCellType() == CellType.FORMULA) {
			return cells.getCellFormula();
		} else {
			return null;
		}
	}

	public Object[][] getsheetAllTestData(int sheetindex) {
		int raws = getTotalRowNumber(sheetindex);
		int cell = getTotalColumnNumber(sheetindex);

		Object[][] data = new Object[raws][cell];
		for (int i = 0; i < raws; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = getSheetTestData(sheetindex, i, j);
			}
		}
		return data;
	}
}
