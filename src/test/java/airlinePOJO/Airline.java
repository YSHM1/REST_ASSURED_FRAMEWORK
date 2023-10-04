package airlinePOJO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import restAssured.utils.DataGenerator;
import restAssured.utils.DataNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode

/*
 * To ignore the fields not present in POJO Class to avoid UnrecognizedPropertException in 
 * Test Class use Annotation @JsonIgnoreProperties(ignoreUnknown = true)
 */
@JsonIgnoreProperties(ignoreUnknown = true) 
@ToString //use to override object to get Object's state in Poiji
public class Airline {
	
	/*
	private int id = Integer.parseInt(DataGenerator.getRandomNumber(6));
	private String name = DataGenerator.getGeneratedData(DataNames.FULLNAME);
	private String country = DataGenerator.getGeneratedData(DataNames.COUNTRY);
	private String logo = DataGenerator.getRandomAlphabets(8);
	private String slogan = DataGenerator.getRandomAlphabets(15);
	private String head_quaters = DataGenerator.getGeneratedData(DataNames.CITYNAME);
	private String website = DataGenerator.getWebsiteNames(15);
	private String established = DataGenerator.getWebsiteNames(15);
	*/
	
	private int id;
	
	@ExcelCell(0) // fetches data from excel cell index 0
	@JsonIgnore //data will not be part of Json(requestPayload)
	private String idValue;

	@ExcelCellName("name") // fetches data from excel cell name ----> name
	private String name;
	@ExcelCellName("country")
	private String country;
	@ExcelCellName("logo")
	private String logo;
	@ExcelCellName("slogan")
	private String slogan;
	@ExcelCellName("head_quaters")
	private String head_quaters; 
	@ExcelCellName("website")
	private String website;
	@ExcelCellName("established")
	private String established;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getSlogan() {
		return slogan;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public String getHead_quaters() {
		return head_quaters;
	}
	
	public void setHead_quaters(String head_quaters) {
		this.head_quaters = head_quaters;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getEstablished() {
		return established;
	}
	
	public void setEstablished(String established) {
		this.established = established;
	}
	
	public String getIdValue() {
		return idValue;
	}
	
	
	
	
	/*
	 * 	 To get value Randomly out of provided Values 
	 	 Useful when a particular field accepts only specific values / limited values
	     private String gender = Stream.of("male", "female", "others").findAny().get();
		         									OR
	     private String gender = Arrays.asList("male", "female", "others").get(DataGenerator.getNumberBetween(0, 3));
	 */

	
	/*
	 * Best practice will be to create Gender ENUM and create Constant Value-----> Male, Female and Others in ENUM
	 * so that even if we are manually  giving value for Gender field it won't be out  of Scope of the values for Gender field 
	 * (Restricting Gender field values)
	 * 
	 * private Gender gender = Arrays.stream(Gender.values()).findAny().get();
	 */ 
	
	

}
