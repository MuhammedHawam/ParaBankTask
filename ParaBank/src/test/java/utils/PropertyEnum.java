package utils;

public enum PropertyEnum {

	APP_URL("app.url"),
	TIME_OUT("test.timeout"),
	TEST_DATA_DIRECTORY("test.data.directory");
	private String value;

	private PropertyEnum(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	@Override
	public String toString() {
		return value;
	}
}
