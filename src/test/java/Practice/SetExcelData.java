package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./data/Excel_Data.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Login_Data");
Row cl = sh.getRow(1);
Cell c = cl.createCell(3);
//c.setCellType(CellType.STRING);
c.setCellValue("PASS");

FileOutputStream fos=new FileOutputStream("./data/Excel_Data.xlsx");
wb.write(fos);
wb.close();
	}

}
