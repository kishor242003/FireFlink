package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Excel_Data.xlsx");
		String data1 = "";
		String data2 = "";
		boolean flag=false;
		String expectedTcId="tc_02";
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Login_Data");
		int rowCount = sh.getLastRowNum();

		for(int i=1;i<=rowCount;i++) {
			String data="";
			try {
				data = sh.getRow(i).getCell(0).getStringCellValue();
				if (data.equals(expectedTcId)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).getStringCellValue();
					data2 = sh.getRow(i).getCell(2).getStringCellValue();
					
				}

			} catch (Exception e) {
			}
			

		}
		if(flag==true) {
			System.out.println(data1);
			System.out.println(data2);
			
		}
		else
			System.out.println("Data is not available");
	}
	

}
