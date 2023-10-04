package airlinePOJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BasePOJO {
	
	@JsonIgnore
	private String scenarioId;
	@JsonIgnore
	private String ScenarioDesc;
	@JsonIgnore
	private int expectedStatusCode;
	@JsonIgnore
	private String expectedErrorMessage;
	
	public String getScenarioId() {
		return scenarioId;
	}
	
	public void setScenarioId(String scenarioId) {
		this.scenarioId = scenarioId;
	}
	
	public String getScenarioDesc() {
		return ScenarioDesc;
	}
	
	public void setScenarioDesc(String scenarioDesc) {
		ScenarioDesc = scenarioDesc;
	}
	
	public int getExpectedStatusCode() {
		return expectedStatusCode;
	}
	
	public void setExpectedStatusCode(int expectedStatusCode) {
		this.expectedStatusCode = expectedStatusCode;
	}
	
	public String getExpectedErrorMessage() {
		return expectedErrorMessage;
	}
	
	public void setExpectedErrorMessage(String expectedErrorMessage) {
		this.expectedErrorMessage = expectedErrorMessage;
	}
	

}
