package user.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import user.GlobalVariables.Env_Var;
import user.payload.UserAddressPOJO;
import user.payload.UserPOJO;
import user.utilities.Constants;
import user.utilities.ExcelReader;

public class UserCRUD {

	static Response response;
	static RequestSpecification request;
	static ResourceBundle rb = ResourceBundle.getBundle("Config/config");

	public static RequestSpecification PostUser() throws IOException, InvalidFormatException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.readTestDataFromExcel(Constants.EXCEL_TEST_DATA, "EndToEndUserAPI");
		System.out.println("***************no of rows of test data**********" + testdata.size());

		String firstname = testdata.get(0).get("Firstname");
		String lastname = testdata.get(0).get("Lastname");
		long contactnumber = Long.parseLong(testdata.get(0).get("Contactnumber"));
		String email = testdata.get(0).get("Emailid");

		UserAddressPOJO userAddress = new UserAddressPOJO();
		userAddress.setPlotNumber(testdata.get(0).get("Plotnumber"));
		userAddress.setStreet(testdata.get(0).get("Street"));
		userAddress.setState(testdata.get(0).get("State"));
		userAddress.setCountry(testdata.get(0).get("Country"));
		userAddress.setZipCode(Integer.parseInt(testdata.get(0).get("Zipcode")));

		UserPOJO userPOJO = new UserPOJO(firstname, lastname, contactnumber, email, userAddress);

		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPOJO);

		request = RestAssured.given().auth().preemptive()
				.basic(rb.getString("userLoginEmailId"), rb.getString("password")).contentType(ContentType.JSON) // Explicitly
																													// setting
																													// content
																													// type
				.body(requestBody).log().all(); // Log all details of the request
		System.out.println("******request body******\n" + requestBody);

		return request;
	}

	public static Response getPostUserResponse(RequestSpecification request) {
		response = request.when().post(rb.getString("base_url") + Constants.PostUser_Endpoint);

		Env_Var.userId = response.path("user_id");
		Env_Var.username = response.path("user_first_name");
		response.then().log().all();

		return response;
	}

	public static RequestSpecification getRequest() {
		request = RestAssured.given().auth().preemptive()
				.basic(rb.getString("userLoginEmailId"), rb.getString("password")).contentType(ContentType.JSON).log()
				.all(); // Log all details of the request

		return request;
	}

	public static Response getGetUserResponse() {
		response = request.when().get(rb.getString("base_url") + Constants.Get_All_Users_Endpoint);

		response.then().log().all();
		return response;
	}

	public static Response get_GetUser_By_Id(RequestSpecification request) {
		response = request.when().get(rb.getString("base_url") + Constants.Get_User_By_UserId + Env_Var.userId);
		response.then().log().all();

		return response;

	}

	public static Response get_GetUser_By_Name(RequestSpecification request) {
		response = request.when().get(rb.getString("base_url") + Constants.Get_User_By_UserName + Env_Var.username);
		response.then().log().all();

		return response;

	}

	public static RequestSpecification PutUser() throws IOException, InvalidFormatException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.readTestDataFromExcel(Constants.EXCEL_TEST_DATA, "EndToEndUserAPI");
		System.out.println("***************no of rows of test data**********" + testdata.size());

		String firstname = testdata.get(0).get("EditFirstname");
		String lastname = testdata.get(0).get("EditLastname");
		long contactnumber = Long.parseLong(testdata.get(0).get("EditContactnumber"));
		String email = testdata.get(0).get("EditEmailid");

		UserAddressPOJO userAddress = new UserAddressPOJO();
		userAddress.setPlotNumber(testdata.get(0).get("EditPlotnumber"));
		userAddress.setStreet(testdata.get(0).get("EditStreet"));
		userAddress.setState(testdata.get(0).get("EditState"));
		userAddress.setCountry(testdata.get(0).get("EditCountry"));
		userAddress.setZipCode(Integer.parseInt(testdata.get(0).get("EditZipcode")));

		UserPOJO userPOJO = new UserPOJO(firstname, lastname, contactnumber, email, userAddress);

		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPOJO);

		request = RestAssured.given().auth().preemptive()
				.basic(rb.getString("userLoginEmailId"), rb.getString("password")).contentType(ContentType.JSON) // Explicitly
																													// setting
																													// content
																													// type
				.body(requestBody).log().all(); // Log all details of the request
		System.out.println("******request body******\n" + requestBody);

		return request;
	}

	public static Response getPutUserResponse(RequestSpecification request) {
		System.out.println("*****************" + Env_Var.userId + "*****************");
		response = request.when().put(rb.getString("base_url") + Constants.PutUser_Endpoint + Env_Var.userId);
		Env_Var.username = response.path("user_first_name");
		response.then().log().all();

		return response;
	}

	public static Response getDelete_User_By_FirstnameResponse(RequestSpecification request) {
		response = request.when()
				.delete(rb.getString("base_url") + Constants.Delete_User_By_Firstname_Endpoint + Env_Var.username);
		response.then().log().all();

		return response;

	}

	public static Response getDelete_User_By_UserId(RequestSpecification request) {
		response = request.when()
				.delete(rb.getString("base_url") + Constants.Delete_User_By_UserId_Endpoint + Env_Var.userId);
		response.then().log().all();

		return response;

	}

}
