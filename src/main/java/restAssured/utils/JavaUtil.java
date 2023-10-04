package restAssured.utils;

public class JavaUtil {
	
	public static String getRandomDataUsing_ExcelCellValue(String cellValue) {
		int size = 7;
		if(cellValue.contains("RandomNumber")) {
			if (cellValue.contains("_")) {
				size = Integer.parseInt((cellValue.split("_"))[1]);
			}
			cellValue = DataGenerator.getRandomNumber(size);
		}
		return cellValue;
	}

}
