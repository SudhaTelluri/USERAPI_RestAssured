package user.utilities;

public class Constants {

	public static final String BASE_PATH = "./src/test/resources/";

	// Json Shema
	public static final String UserPost_JSON_SCHEMA = BASE_PATH + "SchemaValidations/UserPostSchema.txt";
	public static final String Get_JSON_SCHEMA = BASE_PATH + "SchemaValidations/Get_User_By_UserId.txt";
	public static final String Get_JSON_SCHEMA_Name = BASE_PATH + "SchemaValidations/Get_User_By_Firstname.txt";

	// Excel Test data
	public static final String EXCEL_TEST_DATA = BASE_PATH + "TestData.xlsx";

	// Endpoints
	public static final String PostUser_Endpoint = "/createusers";
	public static final String Get_All_Users_Endpoint = "/users";
	public static final String Get_User_By_UserId = "/user/";
	public static final String Get_User_By_UserName = "/users/username/";
	public static final String PutUser_Endpoint = "/updateuser/";
	public static final String Delete_User_By_Firstname_Endpoint = "/deleteuser/username/";
	public static final String Delete_User_By_UserId_Endpoint = "/deleteuser/";

}
