package user.payload;

public class UserAddressPOJO {
	private String plotNumber;
	private String street;
	private String state;
	private String country;
	private int zipCode;

	public UserAddressPOJO(String plno, String strt, String stat, String cntry, int zip) {
		setPlotNumber(plno);
		setStreet(strt);
		setState(stat);
		setCountry(cntry);
		setZipCode(zip);

	}

	public UserAddressPOJO() {
		// Default constructor
	}

	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
