package practciceDDF1;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginFromExcel {
	
  @DataProvider(name="Authentication")
  public Object[][] logindata() throws IOException, Exception, BiffException {
	  
	  String filepath="G:\\Excel data lib\\users_test_data.xls";
	  FileInputStream fis = new FileInputStream(filepath);
	  Workbook wb = Workbook.getWorkbook(fis);
	  Sheet exsheet=wb.getSheet("Sheet1");
	  int rows=exsheet.getRows();
	  int col=exsheet.getColumns();
	  String testdata[][]=new String[rows-1][col];
	  
	  int count=0;
	  for(int i=1;i<rows;i++) {
		  
		  for(int j=0;j<col;j++){
			  
			  Cell xcell=exsheet.getCell(j,i );
			  testdata[count][j]=xcell.getContents();
		  }
		  count++;
		  
	  }
	  fis.close();
	  return testdata;
	  
		
		
		
	  
	  
  
  }
}
