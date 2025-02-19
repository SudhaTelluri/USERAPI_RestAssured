package user.payload;

public class UserPOJO {
	private String user_first_name;
	private String user_last_name;
	private long user_contact_number;
	private String user_email_id;
	private UserAddressPOJO userAddress;

	public UserPOJO() {
		// Default constructor
	}

	public UserPOJO(String user_firstname, String user_lastname, long user_contactnumber, String user_emailid,
			UserAddressPOJO userAddress) {
		this.user_first_name = user_firstname;
		this.user_last_name = user_lastname;
		this.user_contact_number = user_contactnumber;
		this.user_email_id = user_emailid;
		this.userAddress = userAddress;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public long getUser_contact_number() {
		return user_contact_number;
	}

	public void setUser_contact_number(long user_contact_number) {
		this.user_contact_number = user_contact_number;
	}

	public String getUser_email_id() {
		return user_email_id;
	}

	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}

	public UserAddressPOJO getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddressPOJO userAddress) {
		this.userAddress = userAddress;
	}

}
