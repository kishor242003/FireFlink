package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./data/Excel_Data.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Login_Data");
int count = sh.getLastRowNum();

for(int i=1;i<=count;i++) {
	String data1 = sh.getRow(i).getCell(0).getStringCellValue();
		String data = sh.getRow(i).getCell(1).getStringCellValue();
		System.out.println(data1+" "+data);
}
	}

}

