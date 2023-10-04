package restAssured.restUtils;

public class AssertionKeys {
	
	private String jsonPath;
	private Object expectedValues;
	private Object actualValues;
	private String result;
	
	public AssertionKeys(String jsonPath, Object expectedValues, Object actualValues, String result) {
		this.jsonPath = jsonPath;
		this.expectedValues = expectedValues;
		this.actualValues = actualValues;
		this.result = result;
	}

	public String getJsonPath() {
		return jsonPath;
	}

	public Object getExpectedValues() {
		return expectedValues;
	}

	public Object getActualValues() {
		return actualValues;
	}

	public String getResult() {
		return result;
	}

}
