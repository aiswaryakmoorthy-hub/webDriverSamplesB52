package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FetchBookingTest {
  @Test
  public void getAllBookings() {
	  
	  RestAssured.baseURI= "https://restful-booker.herokuapp.com";
	  
	  Response response= RestAssured.get("/booking");
	  
	  int statusCode= response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,200);
	  Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
	  
	  //Retrieve the Body of Response 
	  
	  ResponseBody body=response.getBody();
	  
	  String bodyAsString=body.asString();
	  
	  System.out.println(bodyAsString);
  }
  
  @Test
  
  public void getBookingDetails() {
	  
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  
	  Response response=RestAssured.get("/booking/2");
	  
	  int statusCode=response.getStatusCode();
	  
	  Assert.assertEquals(statusCode, 200);
	  
	  Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
	  
	  System.out.println(response.getBody().asString());
	  
	  
	  JsonPath JsonPathEvaluator =response.jsonPath();
	  
	  String fname=JsonPathEvaluator.get("firstname");
	  
	  Assert.assertEquals(fname,"Sally");
	  
	  Assert.assertEquals(JsonPathEvaluator.get("additionalneeds"),"Breakfast");
	  
	
	  
	 
	  
	  
  }
  
  
}
