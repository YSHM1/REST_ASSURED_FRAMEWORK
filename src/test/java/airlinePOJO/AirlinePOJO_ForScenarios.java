package airlinePOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.poiji.annotation.ExcelCellName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true) 
@ToString 
@JsonInclude(JsonInclude.Include.NON_DEFAULT) //Ignores the field with default values for payload
public class AirlinePOJO_ForScenarios extends BasePOJO{
	
	private int id;
	private String name;
	private String country;
	private String logo;
	private String slogan;
	private String head_quaters; 
	private String website;
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
	
}
