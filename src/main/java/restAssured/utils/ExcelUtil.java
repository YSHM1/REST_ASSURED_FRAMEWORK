package restAssured.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static List<LinkedHashMap<String,String>> getExcelData(String fileName, String sheetName) throws EncryptedDocumentException, IOException {
		List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();
		Workbook workbook = WorkbookFactory.create(new File("./src/test/resources/testdata/"+fileName+".xlsx"));
		Sheet sheet = workbook.getSheet(sheetName);
		
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<String> allkeys = new ArrayList<>();
		LinkedHashMap<String, String> mapData;
		DataFormatter dataFormatter = new DataFormatter();
		
		for (int i = 0; i < totalRow; i++) {
			
			mapData = new LinkedHashMap<>();
			
			if (i==0) {
				int totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
				for (int j = 0; j < totalColumn; j++) {
					allkeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
				}
			}
			
			else {
				int totalCoulmn = sheet.getRow(i).getPhysicalNumberOfCells();
				for (int j = 0; j < totalCoulmn; j++) {
					String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
					
					int size = 7;
					if(cellValue.contains("RandomNumber")) {
						if (cellValue.contains("_")) {
							size = Integer.parseInt((cellValue.split("_"))[1]);
						}
						cellValue = DataGenerator.getRandomNumber(size);
					}
					
					mapData.put(allkeys.get(j), cellValue);
				}
			}
			dataFromExcel.add(mapData);
		}
		return dataFromExcel;
	}
}
