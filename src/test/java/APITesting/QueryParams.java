package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParams//fails -ma'am to check and get back 

{
  @Test
  public void getAllTags() {
	  
	  RestAssured.baseURI= "https://petstore.swagger.io";
	  
	  
	  
	// RequestSpecification request =RestAssured.given();
	 
  
	// Response response= request.queryParam("status","available")
		
	Response response =	   RestAssured.given()
			               .accept("application/json")
			               .queryParam("status", "available")
			               .get("/pet/findByStatus");
			 
			 
			 
	 String jsonString=response.asString();
	 System.out.println(response.getStatusCode());
	 System.out.println(jsonString);
	 Assert.assertEquals(jsonString.contains("available"),true);
 
}

  
}