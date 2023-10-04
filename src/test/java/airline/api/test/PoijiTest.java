package airline.api.test;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

import airlinePOJO.PoijiAirline;

public class PoijiTest {
	
	@Test
	public void poijiTest() {
		/*
		 * If cell contains multiple values separated by semi-colon(;) or any other character
		 * instead of comma(,) we need to use PoijiOptions and provide the PoijiOptions object in 
		 * Poiji.fromExcel(excelFilePath, class, PoijiOptions object) statement
		 */
		PoijiOptions option = PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
		//Fetching data from Excel file  using Poiji.fromExcel() method
		List<PoijiAirline> data = Poiji.fromExcel(new File(".\\src\\test\\resources\\testdata\\AirlineTestDataPoijiPractice.xlsx"), PoijiAirline.class, option);
		System.out.println(data);
		
	}

}
