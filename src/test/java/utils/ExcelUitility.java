package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modals.Person;

public class ExcelUitility {

	public static ArrayList<Person> ReadDataFromExcel() throws IOException {
		ArrayList<Person> list = new ArrayList<Person>();
		FileInputStream fileInputStream = new FileInputStream("C:\\Sask\\Code\\workspace\\LearnMaven\\dataSheet.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int rowIndex = 1; rowIndex <=lastRowNum; rowIndex++) { 
            Row row = sheet.getRow(rowIndex);
            String firstName =  row.getCell(0).getStringCellValue();;
            String lastName = row.getCell(1).getStringCellValue();
            String userName = row.getCell(2).getStringCellValue();
            String city = row.getCell(3).getStringCellValue();
            String state = row.getCell(4).getStringCellValue();
            int zip = (int) row.getCell(5).getNumericCellValue();
            
//            System.out.print(firstName +" " + lastName +" "+userName+" "+city+" "+state+" "+zip);
//            System.out.println();
           Person person = new Person(firstName,lastName,userName,city,state,zip );
           list.add(person);
        
         
      
	}
        return list;
		
	}
}
