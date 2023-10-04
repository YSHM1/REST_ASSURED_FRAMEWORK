package knowledege;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import restAssured.utils.ExcelUtil;

public class GetDataFromExcelUtils {
	
	@Test
	public void getData() throws EncryptedDocumentException, IOException {
		List<LinkedHashMap<String, String>> data = ExcelUtil.getExcelData("AirlineTestData", "CreateAirline");
//		System.out.println(data);
		System.out.println(data.get(1));
		System.out.println(data.get(2));
	}

}
