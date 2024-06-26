package user.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import user.GlobalVariables.Env_Var;
import user.utilities.Constants;

public class UserTests {

	public static void postUserValidation(Response response) throws IOException {
		String schema = FileUtils.readFileToString(new File(Constants.UserPost_JSON_SCHEMA), "UTF-8");
		response.then().assertThat().statusLine("HTTP/1.1 201 ").header("Content-Type", "application/json") // Validate
				.body(JsonSchemaValidator.matchesJsonSchema(schema)) // Validate schema
				.body("user_first_name", Matchers.equalTo("Team")) // Validate data using containsString
				.body("user_last_name", Matchers.equalTo("Three"))
				.body("user_contact_number", Matchers.equalTo(Long.valueOf(8912340670L)))
				.body("user_email_id", Matchers.equalTo("sudhateam3@email.com"))
				.body("userAddress.plotNumber", Matchers.equalTo("PL-03"))
				.body("userAddress.street", Matchers.equalTo("Costco"))
				.body("userAddress.state", Matchers.equalTo("Chicago"))
				.body("userAddress.country", Matchers.equalTo("USA"))
				.body("userAddress.zipCode", Matchers.equalTo(321123));
	}

	public static void getUsersValidation(Response response) throws IOException {
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json")
				.body("user_id", Matchers.hasItem(Env_Var.userId));

	}

	public static void getUser_ById_Validation(Response response) throws IOException {
		String schema = FileUtils.readFileToString(new File(Constants.Get_JSON_SCHEMA), "UTF-8");
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json") // Validate
				.body("user_id", Matchers.equalTo(Env_Var.userId)).body(JsonSchemaValidator.matchesJsonSchema(schema));

	}

	public static void getUser_ByName_Validation(Response response) throws IOException {
		String schema = FileUtils.readFileToString(new File(Constants.Get_JSON_SCHEMA_Name), "UTF-8");
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json") // Validate
				.body("user_first_name", Matchers.hasItem(Env_Var.username))
				.body(JsonSchemaValidator.matchesJsonSchema(schema));

	}

	public static void putUserValidation(Response response) throws IOException {
		String schema = FileUtils.readFileToString(new File(Constants.UserPost_JSON_SCHEMA), "UTF-8");
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json") // Validate
				.body(JsonSchemaValidator.matchesJsonSchema(schema)) // Validate schema
				.body("user_first_name", Matchers.equalTo("team")) // Validate data using containsString
				.body("user_last_name", Matchers.equalTo("three"))
				.body("user_contact_number", Matchers.equalTo(Long.valueOf(8910340677L)))
				.body("user_email_id", Matchers.equalTo("teamwthree@email.com"))
				.body("userAddress.plotNumber", Matchers.equalTo("PL-05"))
				.body("userAddress.street", Matchers.equalTo("Walmart"))
				.body("userAddress.state", Matchers.equalTo("Utah"))
				.body("userAddress.country", Matchers.equalTo("USA"))
				.body("userAddress.zipCode", Matchers.equalTo(321173));
	}

	public static void getDelete_User_By_Firstname_Validation(Response response) {
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json");
	}

	public static void getDelete_User_By_userId_Validation(Response response) {
		response.then().assertThat().statusLine("HTTP/1.1 200 ").header("Content-Type", "application/json"); // Validate
																												// header
	}

}
