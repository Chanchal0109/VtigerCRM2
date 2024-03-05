package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public  String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs = new FileInputStream("src\\test\\resources\\Organization.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rownum);
		Cell cl = rw.getCell(cellnum);
		String value = cl.getStringCellValue();
		return value;
		
	}

	
}


