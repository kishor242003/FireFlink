package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis =new FileInputStream("./data/Excel_Data.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Login_Data");
Row rw = sh.getRow(1);
Cell cl = rw.getCell(1);
String text = cl.getStringCellValue();
System.out.println(text);
	}

}
