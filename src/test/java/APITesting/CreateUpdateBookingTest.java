package APITesting;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUpdateBookingTest {
  @Test
  public void CreateNewBooking() {
	  
	  File jsonFile=new File("src//test/resources//testData//booking.json");
	  
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  
	  Response resp= RestAssured.given()
			        .accept("application/json")//receiving type
			        .contentType("application/json")//sending
			        .body(jsonFile)
			        .post("/booking");
	  
	  System.out.println(resp.getStatusCode());
	  Assert.assertEquals(resp.getStatusCode(), 200);
	  System.out.println(resp.getStatusLine());
	  System.out.println(resp.getBody().prettyPrint());
	  JsonPath jsonPathEvaluator=resp.jsonPath();
	  
	  String fname=jsonPathEvaluator.get("booking.firstname");
	  Assert.assertEquals(fname, "Aiswarya");
	  
  }
		
  @Test
  
  
  public void UpdateBooking() {
	  
	  String strToken="";
	  
	  File bookingFile=new File("src//test/resources//testData//booking.json");
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  
	  
	  File jsonFile=new File("src//test/resources//testData//User.json");
	
	  
	  Response resp= RestAssured.given()
			        .accept("application/json")
			        .contentType("application/json")
			        .body(jsonFile)
			        .post("/auth");
			        
		resp.getBody().jsonPath().prettyPrint()	;   
		strToken=resp.getBody().jsonPath().getString("token");
		System.out.println("Token value..." +strToken);
		
		
		//update code--
		//Response putResp=RestAssured.given()
				
				      //  .accept("application/json")
				      //  .contentType("application/json")
				       // .cookie("token",strToken)
		               // .body(bookingFile)
		               // .put("/booking/200");
		
		
		//System.out.println(putResp.getStatusCode());
		//Assert.assertEquals(putResp.getStatusCode(),200);
		//System.out.println(putResp.getBody().prettyPrint());
		//JsonPath jsonPathEvaluator =putResp.jsonPath();
		//String fname=jsonPathEvaluator.get("firstname");
		//Assert.assertEquals(fname,"Aiswarya");
		
		
		Response delResp=RestAssured.given()
				
				      
				       
				        .contentType("application/json")
				        
				        .cookie("token",strToken)
				        
				        .delete("/booking/206");
		
				        
		System.out.println(delResp.getStatusCode())	;
		System.out.println(delResp.getStatusLine())	;
		Assert.assertEquals(delResp.getStatusCode(), 201);
				        
				        
			        
			        
	  
	  
  }
	  
  }

