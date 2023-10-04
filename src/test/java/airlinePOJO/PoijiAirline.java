package airlinePOJO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;

import lombok.ToString;

//@JsonInclude(JsonInclude.Include.NON_DEFAULT) //Ignores the field with default values for payload

@ToString //Coming from lombok used to Overrides the Object to get the State of an Object 

public class PoijiAirline {
	
	@ExcelCell(0) // fetches data from excel cell index 0 and if data is not int return default value of field
	private int id;
	@ExcelCellName("name") // fetches data from excel cell name ----> name
	private String name;
	@ExcelCellName("country")
	private String country;
	@ExcelCellName("logo")
	private String logo;
	@ExcelCellName("slogan")
	private String slogan;
	@ExcelCellName("head_quaters")
	private List<String> head_quaters; // if a cell contains multiple data separated by , then Poiji return List<String>
	@ExcelCellName("website")
	private String website;
	@ExcelCellName("established")
	private String established;
	
	//segregate the extra fields and returns in the form of Map<String, String>
	@ExcelUnknownCells
	private Map<String,	String> extraCell;

}
