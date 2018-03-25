package lib_excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexceldataconfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public readexceldataconfig(String path) {

		try {
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public String getdata(int sheetnum, int row, int col) {

		sheet = wb.getSheetAt(sheetnum);
		String data0 = sheet.getRow(row).getCell(col).getStringCellValue();
		return data0;

	}

}
