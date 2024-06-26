package user.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import user.GlobalVariables.Env_Var;
import user.actions.UserCRUD;
import user.payload.UserAddressPOJO;
import user.payload.UserPOJO;
import user.tests.UserTests;
import user.utilities.Constants;
import user.utilities.ExcelReader;

public class User_StepDefinitions {

	RequestSpecification request;
	Response response;
	static ResourceBundle rb = ResourceBundle.getBundle("Config/config");

	@Given("Admin creates a request body for the USER API with valid test data")
	public void admin_creates_a_request_body_for_the_user_api_with_valid_test_data()
			throws IOException, InvalidFormatException {
		this.request = UserCRUD.PostUser();
	}

	@When("Admin sends a Post request")
	public void admin_sends_a_post_request() {
		this.response = UserCRUD.getPostUserResponse(request);

		response.then().log().all();
	}

	@Then("Admin receives {int} created status code")
	public void admin_receives_created_status_code(Integer int1) throws IOException {
		response.then().assertThat().statusCode(int1);
		UserTests.postUserValidation(response);
	}

	@Given("Admin creates GET request for the user service API")
	public void admin_creates_get_request_for_the_user_service_api() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends a Get request")
	public void admin_sends_a_get_request() {
		this.response = UserCRUD.getGetUserResponse();
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) throws IOException {
		response.then().assertThat().statusCode(int1);
		UserTests.getUsersValidation(response);
	}

	@Given("Admin creates GET request with valid user id")
	public void admin_creates_get_request_with_valid_user_id() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends the Get request with Valid id")
	public void admin_sends_the_get_request_with_valid_id() {
		this.response = UserCRUD.get_GetUser_By_Id(request);
	}

	@Then("Admin receives Status Code {int} OK with Response Body")
	public void admin_receives_status_code_ok_with_response_body(Integer int1) throws IOException {
		response.then().assertThat().statusCode(int1);
		UserTests.getUser_ById_Validation(response);
	}

	@Given("Admin creates Http request with valid user first name")
	public void admin_creates_http_request_with_valid_user_first_name() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends Get request with valid user name")
	public void admin_sends_get_request_with_valid_user_name() {
		this.response = UserCRUD.get_GetUser_By_Name(request);
		response.then().log().all();

	}

	@Then("Admin receives {int} OK Status with expected username response body")
	public void admin_receives_ok_status_with_expected_username_response_body(Integer int1) throws IOException {
		response.then().assertThat().statusCode(int1);
		UserTests.getUser_ByName_Validation(response);

	}

	@Given("Admin creates PUT Request for the user service API endpoint with Request Body")
	public void admin_creates_put_request_for_the_user_service_api_endpoint_with_request_body()
			throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		this.request = UserCRUD.PutUser();
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() {
		this.response = UserCRUD.getPutUserResponse(request);
		response.then().log().all();
	}

	@Then("Admin receives {int} OK status with updated details in response body.")
	public void admin_receives_ok_status_with_updated_details_in_response_body(Integer int1) throws IOException {

		response.then().assertThat().statusCode(int1);
		UserTests.putUserValidation(response);
	}

	@Given("Admin sets delete request with endpoint and valid username")
	public void admin_sets_delete_request_with_endpoint_and_valid_username() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends User delete request with endpoint")
	public void admin_sends_user_delete_request_with_endpoint() {
		this.response = UserCRUD.getDelete_User_By_FirstnameResponse(request);
		response.then().log().all();
	}

	@Then("Admin receives {int} ok status after deletion")
	public void admin_receives_ok_status_after_deletion(Integer int1) {
		UserTests.getDelete_User_By_Firstname_Validation(response);
		response.then().assertThat().statusCode(int1);
	}

	@Given("Admin sets delete request with endpoint and valid userId")
	public void admin_sets_delete_request_with_endpoint_and_valid_user_id() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends User delete request with id")
	public void admin_sends_user_delete_request_with_id() {
		this.response = UserCRUD.getDelete_User_By_UserId(request);
		response.then().log().all();
	}

	@Then("Admin receives {int} OK status after deleting user with userId")
	public void admin_receives_ok_status_after_deleting_user_with_user_id(Integer int1) {
		UserTests.getDelete_User_By_userId_Validation(response);
		response.then().assertThat().statusCode(int1);
	}

	// Testing User with invalid test data

	@Given("Admin creates request body for the post request")
	public void admin_creates_request_body_for_the_post_request() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends post request with invalid data from sheet {string} and rownum {int}")
	public void admin_sends_post_request_with_invalid_data_from_sheet_and_rownum(String sheetname, Integer rowNum)
			throws IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.readTestDataFromExcel(Constants.EXCEL_TEST_DATA, sheetname);
		System.out.println("***************no of rows of test data**********" + testdata.size());

		Map<String, String> rowData = testdata.get(rowNum);
		System.out.println("***************Test Data for Row " + rowNum + ": " + rowData);

		String firstname = rowData.get("Firstname");
		String lastname = rowData.get("Lastname");
		long contactnumber = Long.parseLong(rowData.get("Contactnumber"));
		String email = rowData.get("Emailid");

		UserAddressPOJO userAddress = new UserAddressPOJO();
		userAddress.setPlotNumber(rowData.get("Plotnumber"));
		userAddress.setStreet(rowData.get("Street"));
		userAddress.setState(rowData.get("State"));
		userAddress.setCountry(rowData.get("Country"));
		userAddress.setZipCode(Integer.parseInt(rowData.get("Zipcode")));
		UserPOJO userPOJO = new UserPOJO(firstname, lastname, contactnumber, email, userAddress);

		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPOJO);
		this.response = request.body(requestBody).post(rb.getString("base_url") + Constants.PostUser_Endpoint);

		response.then().log().all();
	}

	@Then("Admin receives a status code {int} bad request")
	public void admin_receives_a_status_code_bad_request(Integer int1) {
		String actualErrorMessage = response.jsonPath().getString("errorMessage");
		System.out.println("*****************error message*******************" + actualErrorMessage);
		response.then().assertThat().statusCode(400);

	}

	@Given("Admin creates request body for the put request")
	public void admin_creates_request_body_for_the_put_request() {
		this.request = UserCRUD.getRequest();
	}

	@When("Admin sends put request with invalid data from sheet {string} and rownum {int}")
	public void admin_sends_put_request_with_invalid_data_from_sheet_and_rownum(String sheetname, Integer rowNum)
			throws IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.readTestDataFromExcel(Constants.EXCEL_TEST_DATA, sheetname);
		System.out.println("***************no of rows of test data**********" + testdata.size());

		Map<String, String> rowData = testdata.get(rowNum);
		System.out.println("***************Test Data for Row " + rowNum + ": " + rowData);

		String firstname = rowData.get("Firstname");
		String lastname = rowData.get("Lastname");
		long contactnumber = Long.parseLong(rowData.get("Contactnumber"));
		String email = rowData.get("Emailid");

		UserAddressPOJO userAddress = new UserAddressPOJO();
		userAddress.setPlotNumber(rowData.get("Plotnumber"));
		userAddress.setStreet(rowData.get("Street"));
		userAddress.setState(rowData.get("State"));
		userAddress.setCountry(rowData.get("Country"));
		userAddress.setZipCode(Integer.parseInt(rowData.get("Zipcode")));
		UserPOJO userPOJO = new UserPOJO(firstname, lastname, contactnumber, email, userAddress);

		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPOJO);
		this.response = request.body(requestBody)
				.put(rb.getString("base_url") + Constants.PutUser_Endpoint + Env_Var.userId);
		response.then().log().all();
	}

}
